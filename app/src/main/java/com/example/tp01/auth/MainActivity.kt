package com.example.tp01.auth

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp01.R
import com.example.tp01.article.ArticlePage
import com.example.tp01.article.ArticleViewModel
import com.example.tp01.ui.theme.MyMainButton
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MySmallButton
import com.example.tp01.ui.theme.MyTextField
import com.example.tp01.ui.theme.MyTitle
import com.example.tp01.ui.theme.MyWarning

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginNavHost(application = application)
        }
    }
}

@Composable
fun LoginNavHost(application: Application){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "loginPage"
    ){
        composable("loginPage") {
            LoginPage(navController = navController)
        }
        composable("signupPage") {
            RegisterPage(navController = navController)
        }
        composable("recoverPwdPage") {
            RecoverPasswordPage(navController = navController)
        }
        composable("articlesPage") {
            ArticlePage(articleViewModel = ArticleViewModel(application = application),
                navController = navController)
        }
    }
}

@Composable
fun LoginPage(authViewModel: AuthViewModel = AuthViewModel(),
              navController: NavController
){
    val userDataState by authViewModel.loginDTOData.collectAsState()

//    val context = LocalContext.current

    MyPageTemplate(
        R.drawable.kimon_maritz_unsplash_river_valley
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = stringResource(R.string.app_login_title))
        Spacer(modifier = Modifier.weight(1f))
        MyWarning(text = stringResource(R.string.app_login_msg_security))
        Spacer(modifier = Modifier.weight(0.5f))
        MyTextField(label = stringResource(R.string.app_login_field_label_email),
            placeholderText = stringResource(R.string.app_login_field_hint_email),
            icon = Icons.Outlined.Email,
//            value = authViewModel.email,
            value = userDataState.email,
            onValueChange = {authViewModel.updateEmailLogin(it)}
        )
        MyTextField(label = stringResource(R.string.app_login_field_label_password),
            placeholderText = stringResource(R.string.app_login_field_hint_password),
            icon = Icons.Outlined.Lock,
//            value = authViewModel.password,
            value = userDataState.password,
            onValueChange = {authViewModel.updatePasswordLogin(it)},
            isPassword = true
        )
//        val intentRecoverPwd = Intent(context, RecoverPasswordActivity::class.java)
        MySmallButton(text = stringResource(R.string.app_login_button_forgotten_password),
            onClick = {
                navController.navigate("recoverPwdPage")
            })
        Spacer(modifier = Modifier.weight(0.5f))

//        val intentRedirectArticles = Intent(context, ArticleActivity::class.java)
        MyMainButton(text = stringResource(R.string.app_login_button_login),
            onClick = {
                authViewModel.tryToLogin(onLoginSuccess = {
                    navController.navigate("articlesPage")
                })
            })
        Spacer(modifier = Modifier.weight(1.5f))

//        val intentSignup = Intent(context, RegisterActivity::class.java)
        MyMainButton(text = stringResource(R.string.app_login_button_signup),
            onClick = {
                navController.navigate("signupPage")
            })
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val application = LocalContext.current.applicationContext as Application
    LoginNavHost(application)
}


/*
* spacer
* Login Title
* spacer
* Security warning message
* Email field
* Password field
* Forgotten pwd
* spacer
* login button
* spacer
* no account -> register?
* spacer
*
* */
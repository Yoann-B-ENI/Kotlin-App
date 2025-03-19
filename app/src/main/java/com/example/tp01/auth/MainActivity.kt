package com.example.tp01.auth

import android.content.Intent
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tp01.R
import com.example.tp01.article.ArticleActivity
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
            LoginPage()
        }
    }
}


@Composable
fun LoginPage(authViewModel: AuthViewModel = AuthViewModel()){
    val context = LocalContext.current

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
            value = authViewModel.email,
            onValueChange = {authViewModel.updateEmail(it)},
//            value = authViewModel.loggedUser.value.email,
//            onValueChange = {authViewModel.updateEmail(it)}
        )
        MyTextField(label = stringResource(R.string.app_login_field_label_password),
            placeholderText = stringResource(R.string.app_login_field_hint_password),
            icon = Icons.Outlined.Lock,
            value = authViewModel.password,
            onValueChange = {authViewModel.updatePassword(it)},
            isPassword = true
        )
        val intentRecoverPwd = Intent(context, RecoverPasswordActivity::class.java)
        MySmallButton(text = stringResource(R.string.app_login_button_forgotten_password), 
            context = context, intent = intentRecoverPwd)
        Spacer(modifier = Modifier.weight(0.5f))

        val intentRedirectArticles = Intent(context, ArticleActivity::class.java)
        MyMainButton(text = stringResource(R.string.app_login_button_login),
            onClick = {
                authViewModel.tryToLogin()
                if (authViewModel.token != ""){
                    context.startActivity(intentRedirectArticles)
                }
            })
        Spacer(modifier = Modifier.weight(1.5f))

        val intentSignup = Intent(context, RegisterActivity::class.java)
        MyMainButton(text = stringResource(R.string.app_login_button_signup),
            context = context, intent  = intentSignup)
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginPage()
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
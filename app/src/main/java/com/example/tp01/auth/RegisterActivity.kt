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
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp01.R
import com.example.tp01.article.ArticleActivity
import com.example.tp01.ui.theme.MyMainButton
import com.example.tp01.ui.theme.MyMultiField
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MyTextField
import com.example.tp01.ui.theme.MyTitle
import com.example.tp01.ui.theme.MyWarning

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterPage()
        }
    }
}


@Composable
fun RegisterPage(){
    val context = LocalContext.current
    MyPageTemplate(
        R.drawable.ivana_cajina_unsplash_hills
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = stringResource(R.string.app_register_title))
        Spacer(modifier = Modifier.weight(1f))
        MyWarning(text = stringResource(R.string.app_register_msg_security))
        Spacer(modifier = Modifier.weight(0.5f))

        MyTextField(label = stringResource(R.string.app_register_field_username_label),
            placeholderText = stringResource(R.string.app_register_field_username_hint))
        MyTextField(label = stringResource(R.string.app_login_field_label_email),
            placeholderText = stringResource(R.string.app_login_field_hint_email),
            icon = Icons.Outlined.Email)
        MyTextField(label = stringResource(R.string.app_login_field_label_password),
            placeholderText = stringResource(R.string.app_login_field_hint_password),
            icon = Icons.Outlined.Lock)
//        MyTextField(label = stringResource(R.string.app_login_field_label_password),
//            placeholderText = stringResource(R.string.app_login_field_hint_password),
//            icon = Icons.Outlined.Lock)

        MyMultiField(labels = arrayOf(stringResource(R.string.app_register_field_zipcode_label),
            stringResource(R.string.app_register_field_cityname_label)),
            placeholders = arrayOf(stringResource(R.string.app_register_field_zipcode_hint),
                stringResource(R.string.app_register_field_cityname_hint)),
            weights = arrayOf(1f, 2f)
        )
        MyMultiField(labels = arrayOf(stringResource(R.string.app_register_field_phonekey_label),
            stringResource(R.string.app_register_field_phonenumber_label)),
            placeholders = arrayOf(stringResource(R.string.app_register_field_phonekey_hint),
                stringResource(R.string.app_register_field_phonenumber_hint)),
            weights = arrayOf(1f, 3f),
            icons = arrayOf(null, Icons.Outlined.Phone)
        )

        Spacer(modifier = Modifier.weight(1f))
        val intentArticle = Intent(context, ArticleActivity::class.java)
        MyMainButton(text = stringResource(R.string.app_register_button_signup),
            context = context, intent = intentArticle)
        Spacer(modifier = Modifier.weight(1f))
    }
}





@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    RegisterPage()
}


/*
* spacer
* Sign up Title
* spacer
* Security warning message
* Username field
* Email field
* Password field
* Password confirmation
* City code | City
* Phone number 2 elem
* spacer
* sign up button
* spacer
*
* */
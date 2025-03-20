package com.example.tp01.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp01.R
import com.example.tp01.ui.theme.MyMainButton
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MyTextField
import com.example.tp01.ui.theme.MyTitle
import com.example.tp01.ui.theme.MyWarning

class RecoverPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecoverPasswordPage()
        }
    }
}


@Composable
fun RecoverPasswordPage(authViewModel: AuthViewModel = AuthViewModel()){
    val recoverPwdState = authViewModel.recoverPwdDTO.collectAsState()
    val context = LocalContext.current

    MyPageTemplate(
        R.drawable.blake_wisz_unsplash_river_sea_gorge
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = stringResource(R.string.app_recoverpassword_title))
        Spacer(modifier = Modifier.weight(1f))
        MyWarning(text = stringResource(R.string.app_recoverpassword_msg_security))
        Spacer(modifier = Modifier.weight(0.5f))
        MyTextField(label = stringResource(R.string.app_login_field_label_email),
            placeholderText = stringResource(R.string.app_login_field_hint_email),
            icon = Icons.Outlined.Email,
            value = recoverPwdState.value.email,
            onValueChange = {authViewModel.updateEmailRecover(it)}
        )

        val intent = Intent(context, MainActivity::class.java)
        MyMainButton(text = stringResource(R.string.app_recoverpassword_button_sendmail),
            onClick = {
                authViewModel.tryToRecoverPwd(onRecoverSuccess = {
                    context.startActivity(intent)
                })
            })
//        MyMainButton(text = stringResource(R.string.app_recoverpassword_button_sendmail),
//            context = context, intent = intent)
        Spacer(modifier = Modifier.weight(4f))
    }
}




@Preview(showBackground = true)
@Composable
fun RecoverPasswordPreview() {
    RecoverPasswordPage()
}


/*
* spacer
* Recover password title
* spacer
* Warning
* Email field
* Send link button
* spacer
*
* */
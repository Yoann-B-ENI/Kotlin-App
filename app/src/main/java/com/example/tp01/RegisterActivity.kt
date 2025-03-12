package com.example.tp01

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp01.ui.theme.MyImageBackground
import com.example.tp01.ui.theme.MyMainButton
import com.example.tp01.ui.theme.MyMultiField
import com.example.tp01.ui.theme.MySmallButton
import com.example.tp01.ui.theme.MyTextField
import com.example.tp01.ui.theme.MyTitle
import com.example.tp01.ui.theme.MyWarning
import com.example.tp01.ui.theme.TP01Theme

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
    TP01Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            ){
                MyImageBackground(R.drawable.ivana_cajina_unsplash_hills)
                Column (
                    modifier = Modifier.padding(30.dp)
                ){
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
                    MyTextField(label = stringResource(R.string.app_login_field_label_password),
                        placeholderText = stringResource(R.string.app_login_field_hint_password),
                        icon = Icons.Outlined.Lock)

                    MyMultiField(labels = arrayOf(stringResource(R.string.app_register_field_zipcode_label),
                        stringResource(R.string.app_register_field_cityname_label)),
                        placeholders = arrayOf(stringResource(R.string.app_register_field_zipcode_hint),
                            stringResource(R.string.app_register_field_cityname_hint)),
                        weights = arrayOf(1f, 3f)
                    )
                    MyMultiField(labels = arrayOf(stringResource(R.string.app_register_field_phonekey_label),
                        stringResource(R.string.app_register_field_phonenumber_label)),
                        placeholders = arrayOf(stringResource(R.string.app_register_field_phonekey_hint),
                            stringResource(R.string.app_register_field_phonenumber_hint)),
                        weights = arrayOf(1f, 3f),
                        icons = arrayOf(null, Icons.Outlined.Phone)
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    MyMainButton(text = stringResource(R.string.app_register_button_signup))
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
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
package com.example.tp01.demo_intent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp01.R
import com.example.tp01.ui.theme.MyMainButton
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MySmallButton
import com.example.tp01.ui.theme.MyTextField
import com.example.tp01.ui.theme.MyTitle
import com.example.tp01.ui.theme.MyWarning

class DemoPage2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoPage2Page()
        }
    }
}


@Composable
fun DemoPage2Page(){
    MyPageTemplate(
        R.drawable.kimon_maritz_unsplash_river_valley
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = "Demo Page 2")
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {}) {
            Text(text = "Ouvrir Page 1")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Preview(showBackground = true)
@Composable
fun DemoPage2Preview() {
    DemoPage2Page()
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
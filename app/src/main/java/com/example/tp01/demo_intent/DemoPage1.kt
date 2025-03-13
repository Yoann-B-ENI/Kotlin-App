package com.example.tp01.demo_intent

import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.tp01.R
import com.example.tp01.auth.MainActivity
import com.example.tp01.ui.theme.MyMainButton
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MySmallButton
import com.example.tp01.ui.theme.MyTextField
import com.example.tp01.ui.theme.MyTitle
import com.example.tp01.ui.theme.MyWarning

class DemoPage1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoPage1Page()
        }
    }
}


@Composable
fun DemoPage1Page(){
    // Récupérer contexte de l'app
    val context = LocalContext.current

    MyPageTemplate(
        R.drawable.kimon_maritz_unsplash_river_valley
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = "Demo Page 1")
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            // Spécifier quelle activité à ouvrir
            val intent = Intent(context, MainActivity::class.java)
            // Ouvrir l'activité
            // marche parce que MainActivity est dans le manifest
            context.startActivity(intent)
        }) {
            Text(text = "Ouvrir Main Activity")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Preview(showBackground = true)
@Composable
fun DemoPage1Preview() {
    DemoPage1Page()
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
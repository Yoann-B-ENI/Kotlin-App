package com.example.tp01.demo_nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp01.R
import com.example.tp01.ui.theme.MyPageTemplate

class DemoNavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoNavPage()
        }
    }
}


@Composable
fun Page2(navController: NavController){
    MyPageTemplate(
        bg_id = R.drawable.kimon_maritz_unsplash_river_valley
    ) {
        Column {
            Text("Page 2!!")
            ElevatedButton(onClick = {
                navController.navigate("page1")
            }) {
                Text("This opens Page 1")
            }
        }
    }
}

@Composable
fun DemoNavPage(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "page1"
    ){
        composable("page1") {
            Column {
                Text("Page 1")
                ElevatedButton(onClick = {
                    navController.navigate("page2")
                }) {
                    Text("Open Page 2")
                }
            }
        }
        composable("page2") {
            Page2(navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoNavPage()
}


package com.example.tp01.demo_stateful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tp01.R
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MyTitle
import kotlinx.coroutines.flow.MutableStateFlow

class DemoStateful : ComponentActivity() {

    // Observable int counter to pass as parameter
    var counter = MutableStateFlow<Int>(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStatefulPage(counter)
        }
    }
}


@Composable
fun DemoStatefulPage(counter: MutableStateFlow<Int>){
    // observe the changes of counter in real time
    // this only serves to refresh the composant
    // and to display the value
    val counterState by counter.collectAsState()

    MyPageTemplate(
        R.drawable.kimon_maritz_unsplash_river_valley
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = "Demo Stateful")
        Spacer(modifier = Modifier.weight(1f))


        Text(text = "Counter is at ${counterState}",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 50.sp
        )
        Button(onClick = {
            // we modify the real base value
            counter.value += 1
        }) {
            Text(text = "Increment")
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}


@Preview(showBackground = true)
@Composable
fun DemoStatefulPreview() {

    // useless since preview can't have clicks
    var counterPreview = MutableStateFlow<Int>(0)

    DemoStatefulPage(counterPreview)
}


package com.example.tp01.demo_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.tp01.R
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MyTitle
import kotlinx.coroutines.flow.MutableStateFlow

class DemoViewModelActivity : ComponentActivity() {

    // only call the view model, all variables are inside it
    var viewModel = DemoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoViewModelActivityPage(viewModel)
        }
    }
}


@Composable
fun DemoViewModelActivityPage(viewModel: DemoViewModel){
    // observe the persons in the view model (not the VM itself)
    val personsState by viewModel.persons.collectAsState()

    MyPageTemplate(
        R.drawable.kimon_maritz_unsplash_river_valley
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = "Demo Stateful 2 (class)")
        Spacer(modifier = Modifier.weight(1f))

        LazyColumn {
            items(personsState){ person ->
                Text(text = "Person is ${person.username} of age ${person.age}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 50.sp
                )
            }
        }
        Button(onClick = {
            viewModel.persons.value += PersonDemoMVVM("hop", 10)
        }) {
            Text(text = "Increment")
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}


@Preview(showBackground = true)
@Composable
fun DemoViewModelActivityPreview() {

    var viewModel = DemoViewModel()

    DemoViewModelActivityPage(viewModel)
}


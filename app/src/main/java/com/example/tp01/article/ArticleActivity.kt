package com.example.tp01.article

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.tp01.R
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MyTitle

//class ArticleActivity : ComponentActivity() {
//
//    // 'application' is null here, because it's before the constructor
//    // we can use 'lateinit' to declare the var but initialize it later
//    lateinit var viewModel: ArticleViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        // so we initialize it here
//        viewModel = ArticleViewModel(application)
//
//        setContent {
//            ArticlePage(viewModel)
//        }
//    }
//}


@Composable
fun ArticlePage(articleViewModel: ArticleViewModel,
                navController: NavController = rememberNavController()
){
    val articleArray by articleViewModel.arrayArticles.collectAsState()

    MyPageTemplate(
        R.drawable.toan_chu_unsplash_calm_lake
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = stringResource(R.string.app_articlelist_title))
        Spacer(modifier = Modifier.weight(0.5f))
        Row {
            Button(onClick = {
                articleViewModel.addArticle(
                    Article("Article added by button",
                        "This article was added by the button. Here's a dog. ",
                        "https://picsum.photos/id/237/200/300")
                )
            }) {
                Text(stringResource(R.string.app_articlelist_button_addarticle))
            }
            Button(onClick = {
                articleViewModel.removeArticle()
            }) {
                Text(stringResource(R.string.app_articlelist_button_removearticle))
            }
        }
        Button(onClick = {
            articleViewModel.loadArticles()
        }) {
            Text(stringResource(R.string.app_articlelist_button_loadarticles))
        }
        Spacer(modifier = Modifier.weight(0.5f))
        FunShowArticles(articleArray = articleArray)
        Spacer(modifier = Modifier.weight(1f))
    }
}



@Composable
fun FunShowArticles(articleArray : Array<Article>){
    LazyColumn(
    ) {
        items(articleArray){ art ->
            ArticleCard(art)
        }
    }
}

@Composable
fun ArticleCard(art: Article){
    ElevatedCard(
        modifier = Modifier.padding(vertical = 5.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Black
        )
    ) {
        Row {
            AsyncImage(
                model = art.imgPath,
                placeholder = painterResource(R.drawable.perry_kibler_unsplash_fog_bridge),
                contentDescription = art.title,
                modifier = Modifier.width(96.dp).height(96.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxWidth().padding(2.dp)
            ) {
                Text(text = art.title,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color(1f, 1f, 1f, 1f),
                            offset = Offset(5f, 5f),
                            blurRadius = 1f),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(text = art.desc, color = Color.Black)
            }
        }
    }
}






@Preview(showBackground = true)
@Composable
fun ArticlePreview() {

    // Récupérer le context d'application dans le Preview de l'IDE
    val application = LocalContext.current.applicationContext as Application
    val viewModel = ArticleViewModel(application)

    ArticlePage(viewModel)
}


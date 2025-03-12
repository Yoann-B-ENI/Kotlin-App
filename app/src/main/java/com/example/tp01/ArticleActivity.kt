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
import coil3.compose.AsyncImage
import com.example.tp01.ui.theme.MyImageBackground
import com.example.tp01.ui.theme.MyMainButton
import com.example.tp01.ui.theme.MyMultiField
import com.example.tp01.ui.theme.MyPageTemplate
import com.example.tp01.ui.theme.MySmallButton
import com.example.tp01.ui.theme.MyTextField
import com.example.tp01.ui.theme.MyTitle
import com.example.tp01.ui.theme.MyWarning
import com.example.tp01.ui.theme.TP01Theme

class ArticleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticlePage()
        }
    }
}


@Composable
fun ArticlePage(){
    MyPageTemplate(R.drawable.toan_chu_unsplash_calm_lake
    ) {
        val articleArray = arrayOf(
            Article("Article 1 title", "Article description aa aaaaaa aa aaaa aaa aaaa aa aaa ",
                "https://picsum.photos/id/237/200/300"),
            Article("Article 2 title", "Article description",
                "https://picsum.photos/id/237/200/300"),
            Article("Article 3 title", "Article description",
                "https://picsum.photos/id/237/200/300"),
            Article("Article 4 title", "Article description",
                "https://picsum.photos/id/237/200/300"),
            Article("Article 5 title", "Article description",
                "https://picsum.photos/id/237/200/300"),
            Article("Article 6 title", "Article description",
                "https://picsum.photos/id/237/200/300"),
        )

        Spacer(modifier = Modifier.weight(1f))
        MyTitle(text = "Article list")
        Spacer(modifier = Modifier.weight(1f))
        FunShowArticles(articleArray)
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun FunShowArticles(articleArray: Array<Article>){
    for (elem in articleArray){
        Box(modifier = Modifier.fillMaxWidth()
        ){
            Column(modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
            ) {
                Text(text = elem.title,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color(1f, 1f, 1f, 1f),
                            offset = Offset(5f, 5f),
                            blurRadius = 1f),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(text = elem.desc)
                AsyncImage(
                    model = elem.imgPath,
                    contentDescription = elem.title
                )
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ArticlePage()
}


/*
* spacer
* Sign up Title
* spacer
* list articles, for each :
* - title
* - desc
* - img
*
* */
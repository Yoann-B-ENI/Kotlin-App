package com.example.tp01.article

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Article(
    var title: String,
    var desc: String,
    var imgPath: String
) {}

class ArticleViewModel : ViewModel(){
    val arrayArticles = MutableStateFlow<Array<Article>>(emptyArray())

    fun addArticle(art: Article){
        arrayArticles.value += art
    }

    fun removeArticle(){
        arrayArticles.value  = arrayArticles.value.dropLast(1).toTypedArray()
    }
}
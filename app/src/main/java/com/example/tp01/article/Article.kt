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
    private val _arrayArticles = MutableStateFlow<Array<Article>>(emptyArray())
    val arrayArticles: StateFlow<Array<Article>> = _arrayArticles

    fun addArticle(art: Article){
        _arrayArticles.value += art
    }

    fun removeArticle(){
        _arrayArticles.value  = _arrayArticles.value.dropLast(1).toTypedArray()
    }
}
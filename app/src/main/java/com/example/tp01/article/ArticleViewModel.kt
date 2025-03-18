package com.example.tp01.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel(){
    val arrayArticles = MutableStateFlow<Array<Article>>(emptyArray())

    fun addArticle(art: Article){
        arrayArticles.value += art
    }

    fun removeArticle(){
        arrayArticles.value  = arrayArticles.value.dropLast(1).toTypedArray()
    }

    fun loadArticles(){
        viewModelScope.launch {
            // call service
            val apiResponse = ArticleService.ArticleAPI.articleService.getArticles()
            // store response to update all that listens to the array
            arrayArticles.value = apiResponse.toTypedArray()
        }
    }
}
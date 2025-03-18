package com.example.tp01.article

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp01.R
import com.example.tp01.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

// Inherits from ViewModel, or from AndroidViewModel for more functions
class ArticleViewModel(application: Application) : AndroidViewModel(application){
    val arrayArticles = MutableStateFlow<Array<Article>>(emptyArray())

    fun addArticle(art: Article){
        arrayArticles.value += art
    }

    fun removeArticle(){
        arrayArticles.value  = arrayArticles.value.dropLast(1).toTypedArray()
    }

    fun loadArticles(){
        val message = getApplication<Application>().getString(R.string.app_articleviewmodel_loadmessage)
        AppDialogHelpers.get().showDialog(message)

        viewModelScope.launch {
            delay(1000) // fake one sec lag
            val apiResponse = ArticleService.ArticleAPI.articleService.getArticles()

            AppDialogHelpers.get().closeDialog()

            //TODO afficher le message popup clean
            println(apiResponse.message)
            if (apiResponse.code == "200"){
                arrayArticles.value = apiResponse.data?.toTypedArray()!!
            }
        }
    }


} // class
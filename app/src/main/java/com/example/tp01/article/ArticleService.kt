package com.example.tp01.article

import com.example.tp01.api.ResponseAPI
import com.example.tp01.api.RetrofitTools.Companion.retrofit
import retrofit2.http.GET

interface ArticleService {

//    @GET("android-articles.json")
    @GET("articles")
    suspend fun getArticles() : ResponseAPI<List<Article>>

    // implicit singleton
    // can be accessed with PersonAPI.personService
    object ArticleAPI {
        val articleService: ArticleService by lazy { retrofit.create(ArticleService::class.java)}
    }

}
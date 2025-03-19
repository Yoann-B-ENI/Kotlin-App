package com.example.tp01.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitTools {

    // Kotlin :  companion object = static
    companion object{

        // https://raw.githubusercontent.com/Chocolaterie/EniWebService/refs/heads/main/api/android-articles.json
        // 165.232.147.139:3000/articles
        val BASE_URL = "http://192.168.50.2:3000/"

        // L'utilitaire conversion JSON <=> Objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build();

        // Retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build();
    }
}
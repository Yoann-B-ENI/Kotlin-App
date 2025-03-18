package com.example.tp01.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitTools {

    // Kotlin :  companion object = tout ce qui est dedans est statics
    companion object{

        // https://raw.githubusercontent.com/Chocolaterie/EniWebService/refs/heads/main/api/android-articles.json
        val BASE_URL = "https://raw.githubusercontent.com/Chocolaterie/EniWebService/refs/heads/main/api/"

        // L'utilitaire conversion JSON <=> Objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build();

        // Retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL).build();
    }
}
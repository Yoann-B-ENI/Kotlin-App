package com.example.tp01.demo_api

import com.example.tp01.demo_api.RetrofitTools.Companion.retrofit
import retrofit2.http.GET

interface PersonService {

    @GET("persons.json")
    suspend fun getPersons() : List<PersonDemoAPI>

    // implicit singleton
    // can be accessed with PersonAPI.personService
    object PersonAPI {
        val personService : PersonService by lazy {retrofit.create(PersonService::class.java)}
    }
}
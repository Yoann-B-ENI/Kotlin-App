package com.example.tp01.auth

import com.example.tp01.api.ResponseAPI
import com.example.tp01.api.RetrofitTools.Companion.retrofit
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    @Headers("Content-Type: application/json")
    suspend fun login(@Body loginDTO: LoginDTO): ResponseAPI<String>

    @POST("signup")
    @Headers("Content-Type: application/json")
    suspend fun signup(@Body signUpDTO: SignUpDTO): ResponseAPI<SignUpDTO>

    @POST("reset-password")
    @Headers("Content-Type: application/json")
    suspend fun resetPassword(@Body recoverPwdDTO: RecoverPwdDTO): ResponseAPI<String>


    // implicit singleton
    // can be accessed with PersonAPI.personService
    object AuthAPI {
        val authService: AuthService by lazy { retrofit.create(AuthService::class.java)}
    }

}
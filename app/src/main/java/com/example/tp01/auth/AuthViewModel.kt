package com.example.tp01.auth

import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp01.article.ArticleService
import com.example.tp01.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Inherits from ViewModel, or from AndroidViewModel for more functions
class AuthViewModel : ViewModel(){

//    var loggedUser = mutableStateOf(User(" ", " "))
//        private set
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var token: String = ""

    fun updateEmail(input: String) {
        email = input
    }
    fun updatePassword(input: String){
        password = input
    }

    fun tryToLogin(){
        AppDialogHelpers.get().showDialog("Trying to log in...")

        viewModelScope.launch {
            delay(1000) // fake one sec lag
            val apiResponse = AuthService.AuthAPI.authService.login(User(email, password))

            AppDialogHelpers.get().closeDialog()

            //TODO afficher le message popup clean
            println(apiResponse.message)
            if (apiResponse.code == "200"){
                token = apiResponse.data!!
                println("You have successfully logged in!")
            }
            else{
                println("Something went wrong!")
            }
        }
    }



}
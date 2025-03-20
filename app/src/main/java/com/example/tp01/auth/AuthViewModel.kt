package com.example.tp01.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp01.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

// Inherits from ViewModel, or from AndroidViewModel for more functions
class AuthViewModel : ViewModel(){

    var loginDTOData = MutableStateFlow(LoginDTO())
    var recoverPwdDTO = MutableStateFlow(RecoverPwdDTO())
    var signUpDTO = MutableStateFlow(SignUpDTO())

//    var email by mutableStateOf("")
//        private set
//    var password by mutableStateOf("")
//        private set

    companion object {
        var token: String = ""
    }

    fun updateEmailLogin(input: String) {
        loginDTOData.value = loginDTOData.value.copy(email = input)
    }
    fun updatePasswordLogin(input: String){
        loginDTOData.value = loginDTOData.value.copy(password = input)
    }

    fun updateEmailRecover(input: String) {
        recoverPwdDTO.value = recoverPwdDTO.value.copy(email = input)
    }

    fun updateEmailSignup(input: String) {
        signUpDTO.value = signUpDTO.value.copy(email = input)
    }
    fun updatePasswordSignup(input: String){
        signUpDTO.value = signUpDTO.value.copy(password = input)
    }
    fun updatePasswordConfirmSignup(input: String) {
        signUpDTO.value = signUpDTO.value.copy(passwordConfirm = input)
    }
    fun updatePseudoSignup(input: String) {
        signUpDTO.value = signUpDTO.value.copy(pseudo = input)
    }
    fun updateCityCodeSignup(input: String) {
        signUpDTO.value = signUpDTO.value.copy(cityCode = input)
    }
    fun updateCitySignup(input: String) {
        signUpDTO.value = signUpDTO.value.copy(city = input)
    }
    fun updatePhoneSignup(input: String) {
        signUpDTO.value = signUpDTO.value.copy(phone = input)
    }




    fun tryToLogin(onLoginSuccess: () -> Unit = {}){
        AppDialogHelpers.get().showDialog("Trying to log in...")

        viewModelScope.launch {
            // fake one sec lag
            delay(1000)

            val apiResponse = AuthService.AuthAPI.authService.login(loginDTOData.value)
//            val apiResponse = AuthService.AuthAPI.authService.login(User(email, password))

            AppDialogHelpers.get().closeDialog()

            //TODO afficher le message popup clean
            println(apiResponse.message)
            if (apiResponse.code == "200"){
                token = apiResponse.data!!
                println("You have successfully logged in! with token $token")
                onLoginSuccess()
            }
            else{
                println("Something went wrong!")
            }
        }
    }

    //TODO
    fun tryToSignUp(onSignupSuccess: () -> Unit = {}){
        AppDialogHelpers.get().showDialog("Trying to register...")

        viewModelScope.launch {
            // fake one sec lag
            delay(1000)

            val apiResponse = AuthService.AuthAPI.authService.signup(signUpDTO.value)

            AppDialogHelpers.get().closeDialog()

            //TODO afficher le message popup clean
            println(apiResponse.message)
            if (apiResponse.code == "200"){
                println("You have successfully signed up!")
                onSignupSuccess()
            }
            else{
                println("Something went wrong!")
            }
        }
    }

    fun tryToRecoverPwd(onRecoverSuccess: () -> Unit = {}){
        AppDialogHelpers.get().showDialog("Trying to recover password...")
        viewModelScope.launch {
            delay(1000)
            val apiResponse = AuthService.AuthAPI.authService.resetPassword(recoverPwdDTO.value)
            AppDialogHelpers.get().closeDialog()

            //TODO afficher le message popup clean
            println(apiResponse.message)
            if (apiResponse.code == "200"){
                println("You have successfully recovered your pwd! The new pwd is ${apiResponse.data}")
                onRecoverSuccess()
            }
            else{
                println("Something went wrong!")
            }
        }
    }



}
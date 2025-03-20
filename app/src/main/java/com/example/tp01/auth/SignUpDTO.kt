package com.example.tp01.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class SignUpDTO(
    var email: String = "isaac2@gmail.com",
    var password: String = "password",
    var passwordConfirm: String = "password",
    val pseudo: String = "isaac2",
    val cityCode: String = "44000",
    val city: String = "Nantes",
    val phone: String = "0601020304"
) {}


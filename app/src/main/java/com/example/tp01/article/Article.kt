package com.example.tp01.article

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Article(
    var title: String,
    var desc: String,
    var imgPath: String
) {}


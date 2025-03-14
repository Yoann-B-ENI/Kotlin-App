package com.example.tp01.demo_mvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class DemoViewModel : ViewModel() {

    var persons = MutableStateFlow<List<PersonDemoMVVM>>(
            mutableListOf(
            PersonDemoMVVM("aaaa", 3),
            PersonDemoMVVM("bbbb", 5)
        )
    )

}
package com.example.tp01.demo_api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DemoAPIViewModel : ViewModel() {

    // déclarer vide
    var persons = MutableStateFlow<List<PersonDemoAPI>>(mutableListOf())

    /*
    * Function to load the list of persons in the view model
    * */
    fun reloadPersons() {
        // fake api return
//        persons.value = mutableListOf(
//            PersonDemoAPI("fake person 1", 10),
//            PersonDemoAPI("fake person 2", 20)
//        )

        // Coroutine, tâche async,
        // fonctionnalité héritée de ViewModel
        viewModelScope.launch {
            // service api
            val apiResponse = PersonService.PersonAPI.personService.getPersons()
            persons.value = apiResponse
        }
    }
}
package com.example.tp01.api

// exists for the JSON communication,
// since we've decided to always send code, msg, data
class ResponseAPI<T> (var code : String = " ", var message : String = " ", var data : T?) {

}
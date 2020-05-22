package com.vhra.study.notes.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestWebService {
    var api: RestApi private set
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://notes-ex.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(RestApi::class.java)
    }
}


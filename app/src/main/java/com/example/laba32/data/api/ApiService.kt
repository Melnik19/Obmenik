package com.example.laba32.data.api


import com.example.laba32.data.model.bezgotivka

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getbezgotMoney():Response<bezgotivka>

}
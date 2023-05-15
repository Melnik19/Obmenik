package com.example.laba32.data.repository

import com.example.laba32.data.api.RetrofitInstance
import com.example.laba32.data.model.bezgotivka

import retrofit2.Response


class Repository {

    suspend fun getBezgotivka(): Response<bezgotivka>{
        return RetrofitInstance.api.getbezgotMoney()
    }
}
package com.example.k0327_kdy_test

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k0327_kdy_test.retrofit.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application(){

    //add....................................
    var networkService: NetworkService

    val retrofit: Retrofit
        get() = Retrofit.Builder()
            //부산맛집정보서비스
            .baseUrl("http://apis.data.go.kr/6260000/FoodService")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    init {
        networkService = retrofit.create(NetworkService::class.java)
    }
}
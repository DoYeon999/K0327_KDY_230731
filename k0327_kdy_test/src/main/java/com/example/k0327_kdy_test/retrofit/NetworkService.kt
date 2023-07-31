package com.example.k0327_kdy_test.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k0327_kdy_test.R
import com.example.k0327_kdy_test.model.PageListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {


    //부산맛집정보성비스
    // itemModel, PageListModel 참고
//    http://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=인증키&numOfRows=10&pageNo=1
    @GET("FoodService/getFoodKr")
    fun getList(
        @Query("serviceKey") serviceKey: String?,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("resultType") resultType : String
    ): retrofit2.Call<PageListModel>

}
package com.example.k0327_kdy_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.k0327_kdy_test.databinding.ActivityMainBinding
import com.example.k0327_kdy_test.model.PageListModel
import com.example.k0327_kdy_test.recycler.MyAdapter
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //키는 다른 파일에 저장해서, 불러와서 사용하고,
        // 키를 가지고 있는 파일은 .gitIgnore 등록 후 , 원격지에 푸쉬 안함.
        val serviceKey = "tVW2KFmuQi45yJsJGHm71Ud8PRLHZJvrLgyJp7NYkEaT0aVvlkr82a5JJJZrVu4O"
        val serviceKey2 =
            "qBLN%2FSwUij2%2BQ%2FJDA4HhzjYPTFwCy6K8gMvbVm2qrDrIqrU4a45vS9PGsP3PlMizCmzmVtlx8py7QwHHVMI9rg%3D%3D"
        val serviceKey3 =
            "qBLN/SwUij2+Q/JDA4HhzjYPTFwCy6K8gMvbVm2qrDrIqrU4a45vS9PGsP3PlMizCmzmVtlx8py7QwHHVMI9rg=="
        val resultType = "json"

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkService = (applicationContext as MyApplication).networkService

        // 부산맛집정보성비스 : getList, PageListModel
        //부산맛집 _순서1
        val userListCall = networkService.getList(serviceKey3, 1, 100, resultType)

        //부산맛집 _ 순서2
        userListCall.enqueue(object : Callback<PageListModel> {

            //부산 맛집 _ 순서3
            override fun onResponse(
                call: retrofit2.Call<PageListModel>,
                response: Response<PageListModel>
            ) {

                Log.d("kdy", "실행 여부 확인. userListCall.enqueue")
                val userList = response.body()

                //부산맛집로그 _ 순서4
                Log.d("kdy", "userList data 값 : ${userList?.getFoodKr?.item}")
                Log.d("kdy", "userList data 갯수 : ${userList?.getFoodKr?.item?.size}")

                //부산맛집 순서5
                binding.recyclerView.adapter =
                    MyAdapter(this@MainActivity, userList?.getFoodKr?.item)


                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
                )

//                binding.pageView.text=userList?.page
//                binding.totalView.text=userList?.total
            }

            //부산맛집 _순서6
            override fun onFailure(call: retrofit2.Call<PageListModel>, t: Throwable) {
                Log.d("kdy", "fail")
                call.cancel()
            }
        })
    }
}
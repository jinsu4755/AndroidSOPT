package com.antilog.semina_3rd_task2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        //Retrofit으로 받아온 json 데이터를 데이터 클래스로 변환하기 쉽게 한다.
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //service  = requestInterface
    //retrofit 객체의 create 호출, interface 클래스 타입을 넘겨 실제 구현체를 만든다.

    var service: RequestInterface = retrofit.create(RequestInterface::class.java)
}
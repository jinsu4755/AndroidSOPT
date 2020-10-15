package com.antilog.thirdsemina.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//클래스를 만들고 다른 곳에서 불러오면 계속해서 다른 객체가 생성되어 메모리가 사용
/*object로 만들면 싱글톤으로 객체가 1개 생성되어 여러곳에서 가져다 사용할 수 있다.
* 여러 객체를 생성하지 않으니 메모리를 덜 사용할 수 있다.*/
object RequestToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        //Retrofit으로 받아온 json 데이터를 데이터 클래스로 변환하기 쉽게 한다.
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //service  = requestInterface
    //retrofit 객체의 create 호출, interface 클래스 타입을 넘겨 실제 구현체를 만든다.

    var service: RequestInterface = retrofit.create(RequestInterface::class.java)
}
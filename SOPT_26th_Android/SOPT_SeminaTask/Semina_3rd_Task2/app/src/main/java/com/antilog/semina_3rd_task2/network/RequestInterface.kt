package com.antilog.semina_3rd_task2.network

import com.antilog.semina_3rd_task2.data.login.RequestLogin
import com.antilog.semina_3rd_task2.data.login.ResponseLogin
import com.antilog.semina_3rd_task2.data.register.RequestRegister
import com.antilog.semina_3rd_task2.data.register.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    @POST("/user/signin")
    //request 로 RequestLogin 값을 전달하고 Call 로 Response 를 받는다
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestRegister(@Body body: RequestRegister) : Call<ResponseRegister>

}
package com.antilog.thirdsemina.network.login

import com.antilog.thirdsemina.data.login.RequestLogin
import com.antilog.thirdsemina.data.login.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    @POST("/user/signin")
    //request로 ReqeustLogin 값을 전달하고 Call 로 Response 를 받는다
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>
}
package com.antilog.semina_3rd_plustask.network

import com.antilog.semina_3rd_plustask.data.ResponseBook
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RequestInterface {
    @Headers("Authorization: KakaoAK fca68360e1fa150f393a7ad08f8e3375")
    @GET("/v3/search/book")
    fun requestSearchBook(
        @Header("appkey")ket:String,
        @Query("query")bookTitle:String
    ): Call<ResponseBook>
}
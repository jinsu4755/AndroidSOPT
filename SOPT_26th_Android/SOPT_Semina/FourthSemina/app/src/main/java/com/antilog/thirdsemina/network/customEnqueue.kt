package com.antilog.thirdsemina.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <ResponseType> Call<ResponseType>.cutomEnqueue(
    onFail : () -> Unit = { Log.d("Network",  "통신에 실패했습니다.") },
    onSuccess : (ResponseType) -> Unit,
    onError : () -> Unit
) {
    this.enqueue(object : Callback<ResponseType> {
        override fun onFailure(call: Call<ResponseType>, t: Throwable) {onFail()}

        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            response.body()?.let() {
                //body의 statusCode가 200~300인 경우 실행
                onSuccess(it) // 통신결과 전달
            } ?: onError() // response.body()가 null -> statusCode 가 200~300이 아닌경우 onError() 호출
        }

    })
}
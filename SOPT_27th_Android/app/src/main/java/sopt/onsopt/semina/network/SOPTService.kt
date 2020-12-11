/*
 * Created By: jinsu4755
 * on 2020.12.11
 */

package sopt.onsopt.semina.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import sopt.onsopt.semina.domain.user.SignInDomain
import sopt.onsopt.semina.domain.user.SignUpDomain
import sopt.onsopt.semina.network.response.BaseResponse
import sopt.onsopt.semina.network.response.SignInDTO
import sopt.onsopt.semina.network.response.SignUpDTO

interface SOPTService {

    @POST("signup")
    fun requestSignUp(
        @Header("Content-Type") contentType:String = "application/json",
        @Body signUpData:SignUpDomain
    ): Call<BaseResponse<SignUpDTO>>

    @POST("signin")
    fun requestSignIn(
        @Header("Content-Type") contentType:String = "application/json",
        @Body signInData:SignInDomain
    ):Call<BaseResponse<SignInDTO>>

    companion object {
        private const val BASE_URL = "http://15.164.83.210:3000/users/"

        @Volatile
        private var instance: SOPTService? = null

        fun getInstance(): SOPTService = instance ?: synchronized(this) {
            instance ?: provideService(SOPTService::class.java, BASE_URL)
                .apply { instance = this }
        }
    }
}
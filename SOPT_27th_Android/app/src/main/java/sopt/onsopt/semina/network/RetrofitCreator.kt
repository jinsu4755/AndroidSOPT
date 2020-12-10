/*
 * Created By: jinsu4755
 * on 2020.12.8
 */
package sopt.onsopt.semina.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val moshi:Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


fun <T> provideService(clazz: Class<T>, baseUrl: String): T = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()
    .create(clazz)
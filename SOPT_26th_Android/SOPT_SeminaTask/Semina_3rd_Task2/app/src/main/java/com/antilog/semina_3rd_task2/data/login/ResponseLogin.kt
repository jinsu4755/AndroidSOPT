package com.antilog.semina_3rd_task2.data.login

data class ResponseLogin(
    val status: Int,
    val success : Boolean,
    val message : String,
    val data : SomeData?
)

data class SomeData(
    val jwt : String
)
package com.antilog.semina_3rd_task2.data.register

data class RequestRegister(
    val id: String,
    val password: String,
    val name : String,
    val email: String,
    val phone: String
)
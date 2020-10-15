package com.antilog.thirdsemina.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.antilog.thirdsemina.R
import com.antilog.thirdsemina.data.register.RequestRegister
import com.antilog.thirdsemina.data.register.ResponseRegister
import com.antilog.thirdsemina.network.RequestToServer
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    val requestToServer = RequestToServer
    lateinit var toastMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_register -> {
                if (editTextNullOrBlank()) {
                    Toast.makeText(this@RegisterActivity, toastMessage, Toast.LENGTH_SHORT)
                        .show()
                } else {
                    //회원가입 요청시
                    requestRegister()
                }

            }
        }
    }

    private fun requestRegister(){
        requestToServer.service.requestRegister(
            RequestRegister(
                id = et_register_id.text.toString(),
                password = et_register_pw.text.toString(),
                name = et_register_name.text.toString(),
                email = et_register_email.text.toString(),
                phone = et_register_phone.text.toString()
            )
        ).enqueue(object : Callback<ResponseRegister>{
            override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ResponseRegister>,
                response: Response<ResponseRegister>
            ) {
                if (response.body()!!.status == 200) {
                    Toast.makeText(this@RegisterActivity, "아이디 중복!", Toast.LENGTH_SHORT).show()
                }
                if (response.body()!!.success) {
                    Toast.makeText(this@RegisterActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@RegisterActivity,"정보를 정확하게 입력해주세요!", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    private fun editTextNullOrBlank(): Boolean {
        when {
            et_register_id.text.isNullOrBlank() -> {
                toastMessage = "아이디를 입력해주세요"
                return true
            }
            et_register_pw.text.isNullOrBlank() -> {
                toastMessage = "비밀번호를 입력해주세요"
                return true
            }
            et_register_pw_check.text.isNullOrBlank() -> {
                toastMessage = "비밀번호 확인 칸을 작성해주세요"
                return true
            }
            et_register_name.text.isNullOrBlank() -> {
                toastMessage = "이름을 입력해주세요"
                return true
            }
            et_register_email.text.isNullOrBlank() -> {
                toastMessage = "이메일을 입력해주세요"
                return true
            }
            et_register_phone.text.isNullOrBlank() -> {
                toastMessage = "전화번호를를 입력해주세요"
                return true
            }
        }
        return false
    }
}

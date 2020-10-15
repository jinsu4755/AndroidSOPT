package com.antilog.thirdsemina.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antilog.thirdsemina.R
import com.antilog.thirdsemina.data.login.RequestLogin
import com.antilog.thirdsemina.data.login.ResponseLogin
import com.antilog.thirdsemina.network.RequestToServer
import com.antilog.thirdsemina.network.cutomEnqueue
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    val requestToServer =
        RequestToServer//싱글톤 그대로 가져옴
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_id.textChangedListener { s ->
            if (s.isNullOrBlank()) shortToast("아이디가 빈칸입니다!")
        }

        btn_login.setOnClickListener {
            if (et_id.text.isNullOrBlank() || et_password.text.isNullOrBlank()) {
                shortToast("아이디와 비밀번호를 확인하세요")
            } else {
                //로그인 요청
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_password.text.toString()
                    )//로그인 정보를 전달
                ).cutomEnqueue(
                    onError = {shortToast("올바르지 못한 요청입니다.")},
                    onSuccess = {
                        if (it.success) {
                            //ResponseLogin 의 success 가 true 인 경우 -> 로그인
                            shortToast("로그인 성공")
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            shortToast("아이디/비밀번호를 확인하세요")
                        }

                    }
                )
            }
            tv_register.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

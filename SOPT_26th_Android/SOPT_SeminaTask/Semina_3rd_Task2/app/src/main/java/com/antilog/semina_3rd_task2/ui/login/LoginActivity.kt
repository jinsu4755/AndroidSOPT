package com.antilog.semina_3rd_task2.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.antilog.semina_3rd_task2.R
import com.antilog.semina_3rd_task2.data.login.RequestLogin
import com.antilog.semina_3rd_task2.data.login.ResponseLogin
import com.antilog.semina_3rd_task2.network.RequestToServer
import com.antilog.semina_3rd_task2.ui.main.MainActivity
import com.antilog.semina_3rd_task2.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val requestToServer = RequestToServer//싱글톤 그대로 가져옴

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener(this)
        tv_register.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_login -> {
                if (et_id.text.isNullOrBlank() || et_password.text.isNullOrBlank()) {
                    Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
                } else{
                    Log.d("loginTest","로그인 조건 통과-----")
                    //login 요청
                    RequestToServer.service.requestLogin(
                        RequestLogin(
                            id = et_id.text.toString(),
                            password = et_password.text.toString()
                        )
                    ).enqueue(object : Callback<ResponseLogin>{
                        override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                            //로그인 실패
                            Log.e("LoginTest", t.toString())
                        }
                        override fun onResponse(
                            call: Call<ResponseLogin>,
                            response: Response<ResponseLogin>
                        ) {
                            if (response.isSuccessful) {
                                //response status 가 200~300 일때
                                Log.d("loginTest","isSuccessful")
                                if (response.body()!!.success) {
                                    Log.d("loginTest","success")
                                    Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT)
                                        .show()
                                    val intent =
                                        Intent(this@LoginActivity, MainActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Log.d("loginTest","else")
                                    Toast.makeText(this@LoginActivity,"아이디/비밀번호를 확인하세요!",Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }
            }
            R.id.tv_register -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

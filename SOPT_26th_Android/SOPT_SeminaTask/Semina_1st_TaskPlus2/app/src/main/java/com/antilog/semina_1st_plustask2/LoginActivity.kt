package com.antilog.semina_1st_plustask2

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (App.preferences.userId!!.isNotEmpty()) {
            //EditText id= et_id인 View에 userId를 넣어준다.
            et_id.setText(App.preferences.userId)
            et_pw.setText(App.preferences.userPw)

            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }, 1000)

        }



        btn_register.setOnClickListener {
            Log.v("test", "회원가입 버튼 누름")
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        btn_login.setOnClickListener {

            App.preferences.userId = et_id.text.toString()
            App.preferences.userPw = et_pw.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val user_id = data?.getStringExtra("id")
                val user_pw = data?.getStringExtra("pw")
                et_id.setText(user_id)
                et_pw.setText(user_pw)
            }
        }
    }
}

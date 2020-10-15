package com.example.firstsemina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val et_id = findViewById<EditText>(R.id.editText2)
    val et_pw = findViewById<EditText>(R.id.editText3)
    val btn_login = findViewById<Button>(R.id.button)
    val tv_register = findViewById<TextView>(R.id.textView4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            if (et_id.text.isNullOrBlank() || et_pw.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 확인!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterAcitvity::class.java)
            startActivity(intent)
        }
    }
}

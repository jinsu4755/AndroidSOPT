package com.antilog.semina_1st_plustask2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register_end.setOnClickListener {
            val intent = Intent()
            intent.putExtra("id", et_register_id.text.toString())
            intent.putExtra("pw", et_register_pw.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}

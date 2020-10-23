package com.sopt_27.firstseminarequiretask1.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sopt_27.firstseminarequiretask1.R
import com.sopt_27.firstseminarequiretask1.util.afterTextChangeListener
import com.sopt_27.firstseminarequiretask1.util.showToast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private var isNotNullOrBlankName:Boolean = false
    private var isNotNullOrBlankID:Boolean = false
    private var isNotNullOrBlankPassword:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        onCreateStatusExecutionFunction()
    }

    private fun onCreateStatusExecutionFunction(){
        setEditTextChangedEvent()
        setClickEventInView()
    }

    private fun setEditTextChangedEvent(){
        et_sign_up_name.afterTextChangeListener { isNotNullOrBlankName = !it.isNullOrBlank() }
        et_sign_up_id.afterTextChangeListener { isNotNullOrBlankID = !it.isNullOrBlank() }
        et_sign_up_password.afterTextChangeListener { isNotNullOrBlankPassword = !it.isNullOrBlank() }
    }

    private fun setClickEventInView(){
        btn_sign_up_button.setOnClickListener { signUpButtonClickEvent() }
    }

    private fun signUpButtonClickEvent(){
        if (isNotNullOrBlankName && isNotNullOrBlankName && isNotNullOrBlankPassword) {
            sendResponseResultToRequestActivityAndFinish()
            return
        }
        showToast("빈칸이 있는지 확인해주세요~ 😂")
    }

    private fun sendResponseResultToRequestActivityAndFinish() {
        val intent = Intent().apply {
            putExtra("user_id", et_sign_up_id.text.toString())
            putExtra("user_pw", et_sign_up_password.text.toString())
        }
        setResult(RESULT_OK, intent)
        finish()
    }

}
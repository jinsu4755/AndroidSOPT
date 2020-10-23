package com.sopt_27.firstseminarequiretask1.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt_27.firstseminarequiretask1.R
import com.sopt_27.firstseminarequiretask1.data.AuthShardPreferenceRepository
import com.sopt_27.firstseminarequiretask1.ui.main.MainActivity
import com.sopt_27.firstseminarequiretask1.ui.signup.SignUpActivity
import com.sopt_27.firstseminarequiretask1.util.afterTextChangeListener
import com.sopt_27.firstseminarequiretask1.util.showToast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var isNotNullOrBlankID:Boolean = false
    private var isNotNullOrBlankPassword:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        onCreateStatusExecutionFunction()
    }

    private fun onCreateStatusExecutionFunction() {
        checkEnableAutoLogin()
        setEditTextChangeListener()
        setClickEventInView()
    }

    private fun checkEnableAutoLogin(){
        if (AuthShardPreferenceRepository.getInstance(applicationContext)
                .haveUserIdAndUserPassword()
        ) onSuccessLoginEvent()
    }

    private fun setEditTextChangeListener(){
        et_login.afterTextChangeListener { isNotNullOrBlankID = !it.isNullOrBlank() }
        et_password.afterTextChangeListener { isNotNullOrBlankPassword = !it.isNullOrBlank() }
    }

    private fun setClickEventInView() {
        btn_login_button.setOnClickListener {clickLoginButtonEvent()}
        tv_register_button.setOnClickListener { changeActivityForResultUseIntent(SignUpActivity::class.java) }
    }

    private fun clickLoginButtonEvent(){
        if (isNotNullOrBlankID && isNotNullOrBlankPassword) {
            saveUserIdAndUserPassword()
            onSuccessLoginEvent()
            return
        }
        showToast("로그인 혹인 비밀번호 입력을 해주세요!")
    }

    private fun onSuccessLoginEvent(){
        showToast("로그인 성공👍😁")
        changeActivityUseIntentAndFinish(MainActivity::class.java)
    }

    private fun saveUserIdAndUserPassword() {
        AuthShardPreferenceRepository.getInstance(applicationContext)
            .apply {
                saveUserId(et_login.text.toString())
                saveUserPassword(et_password.text.toString())
            }

    }

    private fun changeActivityUseIntentAndFinish(className: Class<*>) {
        val intent = Intent(applicationContext, className)
        startActivity(intent)
        finish()
    }

    private fun changeActivityForResultUseIntent(className: Class<*>) {
        val intent = Intent(applicationContext, className)
        startActivityForResult(intent, REQUEST_SIGN_UP)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_SIGN_UP && resultCode == RESULT_OK) {
            et_login.setText(data?.getStringExtra("user_id"))
            et_password.setText(data?.getStringExtra("user_pw"))
        }
    }

    companion object {
        const val REQUEST_SIGN_UP = 1001
    }
}
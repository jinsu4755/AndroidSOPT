package sopt.onsopt.semina.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import sopt.onsopt.semina.databinding.ActivityLoginBinding
import sopt.onsopt.semina.presentation.MainActivity
import sopt.onsopt.semina.presentation.signup.SignUpActivity


class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
        initView(binding)
    }

    private fun initView(binding: ActivityLoginBinding) {
        binding.btnLoginButton.setOnClickListener { onLoginEvent() }
        binding.tvSignUpButton.setOnClickListener { changeSignUpActivityForResult() }
    }

    private fun onLoginEvent() {
        if (loginViewModel.validateLoginForm()) {
            changeMainActivityAndFinish()
            Toast.makeText(applicationContext, "Hello!", Toast.LENGTH_SHORT)
                .show()
            return
        }
        Toast.makeText(applicationContext, "check your id/pw", Toast.LENGTH_SHORT)
            .show()
    }

    private fun changeMainActivityAndFinish() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun changeSignUpActivityForResult() {
        val intent = Intent(applicationContext, SignUpActivity::class.java)
        startActivityForResult(intent, LoginViewModel.SIGN_UP_REQUEST_CODE)
    }


}
package sopt.onsopt.semina.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import sopt.onsopt.semina.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        binding.signUpViewModel = signUpViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
        initViewObserve()
        initViewBind(binding)
    }

    private fun initViewObserve() {
        userNameObserve()
        userIdObserve()
        userPasswordObserve()
    }

    private fun userNameObserve() {
        signUpViewModel.userName.observe(this) { name ->
            signUpViewModel.checkUserName(name)
        }
    }

    private fun userIdObserve() {
        signUpViewModel.userId.observe(this) { id ->
            signUpViewModel.checkUserId(id)
        }
    }

    private fun userPasswordObserve() {
        signUpViewModel.userPassword.observe(this) { password ->
            signUpViewModel.checkUserPassword(password)
        }
    }

    private fun initViewBind(binding: ActivitySignUpBinding) {
        binding.signUpButton.setOnClickListener { signUpEvent() }
    }

    private fun signUpEvent() {
        if (signUpViewModel.validateSignUpInputValueNotNull()) {
            sendSignUpResultAndFinish()
        }
    }

    private fun sendSignUpResultAndFinish() {
        setResult(SignUpViewModel.SIGN_UP_RESULT_OK, createExtraDataIntent())
        finish()
    }

    private fun createExtraDataIntent(): Intent {
        return Intent().apply {
            putExtra("userName", signUpViewModel.userName.value)
            putExtra("userId", signUpViewModel.userId.value)
            putExtra("userPassword", signUpViewModel.userPassword.value)
        }
    }

}
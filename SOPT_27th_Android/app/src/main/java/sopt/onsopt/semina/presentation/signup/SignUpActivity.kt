package sopt.onsopt.semina.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sopt.onsopt.semina.R
import sopt.onsopt.semina.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = makeDataBinding()
        binding.signUpViewModel = signUpViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
        initViewObserve()
        initViewBind(binding)
    }

    private fun makeDataBinding(): ActivitySignUpBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

    private fun initViewObserve() {
        userNameObserve()
        userIdObserve()
        userPasswordObserve()
    }

    private fun userNameObserve() {
        signUpViewModel.userName.observe(this) {
            signUpViewModel.checkUserName()
        }
    }

    private fun userIdObserve() {
        signUpViewModel.userId.observe(this) {
            signUpViewModel.checkUserId()
        }
    }

    private fun userPasswordObserve() {
        signUpViewModel.userPassword.observe(this) {
            signUpViewModel.checkUserPassword()
        }
    }

    private fun initViewBind(binding: ActivitySignUpBinding) {
        binding.signUpButton.setOnClickListener { signUpEvent() }
    }

    private fun signUpEvent() {
        if (signUpViewModel.isNotNullOrBlankUserData.value == true) {
            sendSignUpResultAndFinish()
        }
    }

    private fun sendSignUpResultAndFinish() {
        setResult(RESULT_OK, createExtraDataIntent())
        finish()
    }

    private fun createExtraDataIntent(): Intent {
        return Intent().apply {
            putExtra("userData", signUpViewModel.createUserDomain())
        }
    }


}
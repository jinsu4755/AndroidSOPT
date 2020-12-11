package sopt.onsopt.semina.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sopt.onsopt.semina.R
import sopt.onsopt.semina.databinding.ActivitySignUpBinding
import sopt.onsopt.semina.domain.user.SignUpDomain
import sopt.onsopt.semina.network.request.SignUpRequest
import sopt.onsopt.semina.network.response.BaseResponse
import sopt.onsopt.semina.network.response.SignUpDTO
import sopt.onsopt.semina.utils.ui.showToast

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
            requestSignUp()
        }
    }

    private fun requestSignUp() {
        SignUpRequest(signUpViewModel.createUserDomain()).apply {
            setOnSuccessListener { sendSignUpResultAndFinish() }
            setOnErrorListener { showToast(it.toString()) }
        }.send()
    }

    private fun sendSignUpResultAndFinish() {
        setResult(RESULT_OK, createExtraDataIntent(signUpViewModel.createUserDomain()))
        finish()
    }

    private fun createExtraDataIntent(signUpData: SignUpDomain): Intent {
        return Intent().apply {
            putExtra("userData", signUpData)
        }
    }


}
package sopt.onsopt.semina.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import sopt.onsopt.semina.databinding.ActivityLoginBinding
import sopt.onsopt.semina.domain.user.SignInDomain
import sopt.onsopt.semina.domain.user.SignUpDomain
import sopt.onsopt.semina.local.AuthLocalRepository
import sopt.onsopt.semina.network.request.SignInRequest
import sopt.onsopt.semina.presentation.main.MainActivity
import sopt.onsopt.semina.presentation.signup.SignUpActivity
import sopt.onsopt.semina.utils.loggingDebug
import sopt.onsopt.semina.utils.ui.showToast


class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this
        autoLoginEvent()
        setContentView(binding.root)
        initView(binding)
    }

    private fun autoLoginEvent() {
        /*if (AuthLocalRepository.getInstance(this@LoginActivity).hasUserData()) {
            AuthLocalRepository.getInstance(this@LoginActivity).apply {
                loggingDebug("userInfo","userName:$userName","userId:$userId")
            }
            showToast("Success Auto Login")
            changeMainActivityAndFinish()
        }*/
    }

    private fun initView(binding: ActivityLoginBinding) {
        binding.btnLoginButton.setOnClickListener { onLoginEvent() }
        binding.tvSignUpButton.setOnClickListener { changeSignUpActivityForResult() }
    }

    private fun onLoginEvent() {
        if (loginViewModel.validateLoginForm()) {
            requestSignIn()
            return
        }
        showToast("check your id/pw")
    }

    private fun requestSignIn() {
        val signInData = SignInDomain(
            email = loginViewModel.editTextId.get()!!,
            password = loginViewModel.editTextPassword.get()!!
        )
        SignInRequest(signInData).apply {
            setOnSuccessListener { changeMainActivityAndFinish() }
            setOnErrorListener { showToast(it.toString()) }
        }.send()
    }

    private fun changeMainActivityAndFinish() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        showToast("Hello!!")
        finish()
    }

    private fun changeSignUpActivityForResult() {
        val intent = Intent(applicationContext, SignUpActivity::class.java)
        startActivityForResult(intent, LoginViewModel.SIGN_UP_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LoginViewModel.SIGN_UP_REQUEST_CODE && resultCode == RESULT_OK) {
            applyUserData(data?.getParcelableExtra("userData"))
        }
    }

    private fun applyUserData(signUpData: SignUpDomain?) {
        signUpData?.let {
            sendDataToViewModel(it)
            saveDataToRepository(it)
        }
    }

    private fun sendDataToViewModel(signUpDomain: SignUpDomain) = loginViewModel.apply {
        editTextId.set(signUpDomain.email)
        editTextPassword.set(signUpDomain.password)
    }

    private fun saveDataToRepository(signUpDomain: SignUpDomain) {
        AuthLocalRepository.getInstance(this@LoginActivity)
            .addAllData(signUpDomain)
    }


}
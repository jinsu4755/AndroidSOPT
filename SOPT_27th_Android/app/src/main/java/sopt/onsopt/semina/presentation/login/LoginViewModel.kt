package sopt.onsopt.semina.presentation.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val editTextId = ObservableField<String>()
    val editTextPassword = ObservableField<String>()

    fun validateLoginForm(): Boolean {
        return !checkNullOrBlankId() && !checkNullOrBlankPassword()
    }

    private fun checkNullOrBlankId() = editTextId.get().isNullOrBlank()
    private fun checkNullOrBlankPassword() = editTextPassword.get().isNullOrBlank()

    companion object {
        const val SIGN_UP_REQUEST_CODE = 1001
    }
}
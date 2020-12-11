package sopt.onsopt.semina.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sopt.onsopt.semina.domain.user.SignUpDomain

class SignUpViewModel : ViewModel() {

    private val _isBlankUserName = MutableLiveData(true)
    val isBlankUserName: LiveData<Boolean>
        get() = _isBlankUserName

    private val _isBlankUserID = MutableLiveData(true)
    val isBlankUserID: LiveData<Boolean>
        get() = _isBlankUserID

    private val _isBlankUserPassword = MutableLiveData(true)
    val isBlankUserPassword: LiveData<Boolean>
        get() = _isBlankUserPassword

    private val _isNotNullOrBlankUserData = MutableLiveData(false)
    val isNotNullOrBlankUserData: LiveData<Boolean>
        get() = _isNotNullOrBlankUserData

    val userName = MutableLiveData<String>()
    val userId = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()


    fun checkUserName() {
        _isBlankUserName.value = userName.value?.isBlank()
        validateSignUpInputValueNotNull()
    }

    fun checkUserId() {
        _isBlankUserID.value = userId.value?.isBlank()
        validateSignUpInputValueNotNull()
    }

    fun checkUserPassword() {
        _isBlankUserPassword.value = userPassword.value?.isBlank()
        validateSignUpInputValueNotNull()
    }

    private fun validateSignUpInputValueNotNull() {
        _isNotNullOrBlankUserData.value = !(isBlankUserName.value ?: true)
                && !(isBlankUserID.value ?: true)
                && !(isBlankUserPassword.value ?: true)
    }

    fun createUserDomain(): SignUpDomain = SignUpDomain(
        userName = userName.value,
        email = userId.value,
        password = userPassword.value
    )
}
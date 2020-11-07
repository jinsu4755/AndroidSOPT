package sopt.onsopt.semina.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    private val _isBlankUserName = MutableLiveData<Boolean>(true)
    private val _isBlankUserID = MutableLiveData<Boolean>(true)
    private val _isBlankUserPassword = MutableLiveData<Boolean>(true)

    val isBlankUserName: LiveData<Boolean>
        get() = _isBlankUserName
    val isBlankUserID: LiveData<Boolean>
        get() = _isBlankUserID
    val isBlankUserPassword: LiveData<Boolean>
        get() = _isBlankUserPassword

    val userName = MutableLiveData("")
    val userId = MutableLiveData("")
    val userPassword = MutableLiveData("")


    fun checkUserName(userName: String) {
        _isBlankUserName.value = userName.isBlank()
    }

    fun checkUserId(userId: String) {
        _isBlankUserID.value = userId.isBlank()
    }

    fun checkUserPassword(userPassword: String) {
        _isBlankUserPassword.value = userPassword.isBlank()
    }

    fun validateSignUpInputValueNotNull() =
        !(isBlankUserName.value ?: true && isBlankUserID.value ?: true && isBlankUserPassword.value ?: true)

    companion object{
        const val SIGN_UP_RESULT_OK = 1002
    }
}
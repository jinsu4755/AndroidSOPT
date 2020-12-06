package sopt.onsopt.semina.local

import android.app.Activity
import android.content.Context
import sopt.onsopt.semina.domain.user.UserDomain

class AuthLocalRepository private constructor(context: Context) {
    private val shardPreference =
        context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)

    private val editor = shardPreference.edit()

    var userId: String?
        get() = shardPreference.getString(USER_ID, null)
        set(value) = editor.putString(USER_ID, value)
            .apply()

    var userPassword: String?
        get() = shardPreference.getString(USER_PW, null)
        set(value) = editor.putString(USER_PW, value)
            .apply()

    var userName: String?
        get() = shardPreference.getString(USER_NAME, null)
        set(value) = editor.putString(USER_NAME, value)
            .apply()

    fun addAllData(userDomain: UserDomain) = editor.apply {
        putString(USER_ID, userDomain.userId)
        putString(USER_PW, userDomain.userPassword)
        putString(USER_NAME, userDomain.userName)
    }.apply()

    fun removeAllData() = editor.apply {
        remove(USER_ID)
        remove(USER_PW)
        remove(USER_NAME)
    }.commit()

    fun hasUserData(): Boolean = userId?.isNotBlank() ?: false
            && userPassword?.isNotBlank() ?: false
            && userName?.isNotBlank() ?: false


    companion object {
        private const val LOCAL_REPO = "SOPT_Auth"
        private const val USER_ID = "${LOCAL_REPO}_ID"
        private const val USER_PW = "${LOCAL_REPO}_PW"
        private const val USER_NAME = "${LOCAL_REPO}_Name"

        @Volatile
        private var instance: AuthLocalRepository? = null

        fun getInstance(context: Context): AuthLocalRepository = instance ?: synchronized(this) {
            instance ?: AuthLocalRepository(context).apply {
                instance = this
            }
        }
    }
}


# ✅SOPT_27 Android

> 각 주차마다 branch를 만들어 기록하고있습니다.
>
> Master에서는 가장 마지막의 과제 정보를 담고있습니다. 이전 과제 정보는 branch를 변경하시면 볼 수 있습니다.



## 1️⃣2020/10/23 1차 세미나 과제

### ◾ 화면 및 플로우

![screenAndFlow](/README/Image/week1/ScreenAndFlow.png)

---

### ◾ Preview

![preview](/README/Image/week1/firstweek.gif)

---

### ◾ Feature

- SignUp
- Login
  - AutoLogin

---

### ◾ How?

최대한 하나의 함수가 한가지 일을 하도록 초점을 두었습니다.



#### ◾ SignUp And Login NotNullOrBlack Check

🥕 EditText가 Null 혹은 Blank인지 확인하는 변수를 두어 EditText 입력 후에 변경될 수 있도록 하였습니다.

```kotlin
et_sign_up_name.afterTextChangeListener { isNotNullOrBlankName = !it.isNullOrBlank() }
```



🥕 입력후에 EditText 내부 Text변화를 감지할 수 있는 TextChangeListener를 필요부분 만 사용하기 위해 확장함수를 사용하였습니다.

```kotlin
fun EditText.afterTextChangeListener(listener: (text:Editable?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun afterTextChanged(text: Editable?) {
            listener(text)
        }
    })
}
```

 

🥕 회원 가입 버튼을 누르면 기존의 checking 변수를 사용하여 이벤트 처리를 합니다.

```kotlin
btn_sign_up_button.setOnClickListener { signUpButtonClickEvent() }
```

```kotlin
    private fun signUpButtonClickEvent(){
        if (isNotNullOrBlankName && isNotNullOrBlankName && isNotNullOrBlankPassword) {
            sendResponseResultToRequestActivityAndFinish()
            return
        }
        showToast("빈칸이 있는지 확인해주세요~ 😂")
    }
```





#### ◾ AutoLogin

🥕  로그인 버튼을 누르면 사용자의 id, pw를 기억합니다.

```kotlin
    private fun clickLoginButtonEvent(){
        if (isNotNullOrBlankID && isNotNullOrBlankPassword) {
            saveUserIdAndUserPassword()
            onSuccessLoginEvent()
            return
        }
        showToast("로그인 혹인 비밀번호 입력을 해주세요!")
    }

    private fun saveUserIdAndUserPassword() {
        AuthShardPreferenceRepository.getInstance(applicationContext)
            .apply {
                saveUserId(et_login.text.toString())
                saveUserPassword(et_password.text.toString())
            }

    }

```



🥕 LoginActivity 초반에 Shared_pref에 사용자 id,pw가 있으면 로그인을 건너뛰고 Main으로 보냅니다.

```kotlin
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
```



🥕 사용자 정보를 저장할 수 있는 Sherd_pref는 싱글턴으로 구현하였으며 멀티쓰레드 환경을 고려하여 작성하였습니다. 더불어 정보를 저장하고 뱉어내는 책임에 정보가 있는지 물어보는 것도 포함된다고 생각하여 내부적으로 값이 있는지 물어보는 `haveUserIdAndUserPassword()` 메소드를 추가했습니다.

```kotlin
class AuthShardPreferenceRepository private constructor(context: Context) {

    private val shardPreference =
        context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)

    private val editor = shardPreference.edit()

    val user_id: String?
        get() = shardPreference.getString(AUTH_SHARD_PREF + "_ID", null)

    val user_password: String?
        get() = shardPreference.getString(AUTH_SHARD_PREF + "_PW", null)

    fun saveUserId(id: String) {
        editor.putString(AUTH_SHARD_PREF + "_ID", id)
            .apply()
    }

    fun saveUserPassword(password: String) {
        editor.putString(AUTH_SHARD_PREF + "_PW", password)
            .apply()
    }

    fun removeUserId() {
        editor.remove(AUTH_SHARD_PREF + "_ID")
            .commit()
    }

    fun removeUserPassword() {
        editor.remove(AUTH_SHARD_PREF + "_PW")
            .commit()
    }

    fun haveUserIdAndUserPassword(): Boolean {
        return !user_id.isNullOrBlank() && !user_password.isNullOrBlank()
    }


    companion object {

        const val AUTH_SHARD_PREF: String = "SOPT_Auth"

        @Volatile
        private var instance: AuthShardPreferenceRepository? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: AuthShardPreferenceRepository(context).apply {
                instance = this
            }
        }
    }
}
```


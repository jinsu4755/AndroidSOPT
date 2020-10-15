package com.antilog.thirdsemina.ui

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/*Edit Text의 확장함수 textChangedListener
* @param textChanged -> 함수를 매게 변수로 받는다.
* 해당 함수는 CharSequence를 매게변수로 받아온다. return 값은 Unit(없다) */
fun EditText.textChangedListener(textChanged : (CharSequence?) -> Unit) {
    //fun textchanged( variable : CharSequence?){}를 매개 변수로 받은 것임

    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) = Unit
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // 해당 함수는 사용시 정의한다.
            textChanged(s)
        }
    })
}
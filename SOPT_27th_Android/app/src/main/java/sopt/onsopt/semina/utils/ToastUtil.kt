package sopt.onsopt.semina.utils

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.showToast(msg: String) {
    Toast.makeText(
        this.applicationContext,
        msg,
        Toast.LENGTH_SHORT
    ).show()
}

fun Fragment.showToast(msg: String) {
    Toast.makeText(
        this.requireContext(),
        msg,
        Toast.LENGTH_SHORT
    ).show()
}
package sopt.onsopt.semina.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import sopt.onsopt.semina.R
import sopt.onsopt.semina.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private var binding:ActivitySignUpBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
    }
}
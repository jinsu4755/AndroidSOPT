package sopt.onsopt.semina.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import sopt.onsopt.semina.R
import sopt.onsopt.semina.databinding.FragmentHomeBinding

class HomeFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding:FragmentHomeBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_home, container, false)
        initView(binding)
        return binding.root
    }

    private fun initView(binding: FragmentHomeBinding) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
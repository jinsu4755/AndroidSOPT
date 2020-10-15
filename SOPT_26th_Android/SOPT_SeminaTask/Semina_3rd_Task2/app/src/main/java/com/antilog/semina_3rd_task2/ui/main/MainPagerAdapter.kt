package com.antilog.semina_3rd_task2.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.antilog.semina_3rd_task2.ui.main.fragment.BookFragment
import com.antilog.semina_3rd_task2.ui.main.fragment.home.HomeFragment
import com.antilog.semina_3rd_task2.ui.main.fragment.PersonFragment

class MainPagerAdapter(fm : FragmentManager):FragmentPagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> BookFragment()
            else -> PersonFragment()
        }
    }

    override fun getCount(): Int = 3

}
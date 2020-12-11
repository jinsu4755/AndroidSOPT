/*
 * Created By: jinsu4755
 * on 2020.12.11
 */

package sopt.onsopt.semina.presentation.main.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.lang.IllegalStateException

class ProfileViewPagerAdapter(
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> InfoFirstFragment()
        1 -> InfoSecondFragment()
        else -> throw IllegalStateException("존재하지 않는 탭 접근.")
    }
}

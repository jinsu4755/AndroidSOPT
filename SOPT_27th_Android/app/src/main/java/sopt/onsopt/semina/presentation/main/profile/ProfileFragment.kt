/*
 * Created By: jinsu4755
 * on 2020.12.10
 */

package sopt.onsopt.semina.presentation.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import sopt.onsopt.semina.R
import sopt.onsopt.semina.databinding.FragmentProfileBinding
import sopt.onsopt.semina.network.request.GitProfileRequest
import sopt.onsopt.semina.network.response.ProfileDTO

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private var viewPagerAdapter:ProfileViewPagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestUserProfile()
        initViewPager()
    }

    private fun initViewPager() {
        viewPagerAdapter = ProfileViewPagerAdapter(requireActivity().supportFragmentManager)
        binding.viewPagerInfo.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPagerInfo)
        binding.tabLayout.apply {
            getTabAt(0)?.text = "INFO1"
            getTabAt(1)?.text = "INFO2"
        }
    }

    private fun requestUserProfile() {
        GitProfileRequest().apply {
            setOnSuccessListener { onSuccessGetProfile(it) }
        }.send()
    }

    private fun onSuccessGetProfile(profileDTO: ProfileDTO) {
        binding.gitProfile = profileDTO.asDomainModel()
    }
}
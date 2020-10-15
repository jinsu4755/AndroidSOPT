package com.example.secondsemina

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home_fragment.*

/**
 * A simple [Fragment] subclass.
 */
class Home_fragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    val datas = mutableListOf<InstaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter
        loadDatas()
    }

    private fun loadDatas() {
        datas.apply {
            add(
                InstaData(
                    userName = "Park",
                    img_profile = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fd44x6A%2Fbtqzu7dKbZ6%2FlOoGM6j0rjWD3p8kKfB8ck%2Fimg.jpg",
                    img_contents = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FcdiIf5%2FbtqDsaeCxMV%2FbeY1EOcnnVBaXHVqyXOC5K%2Fimg.png"
                )
            )
            add(
                InstaData(
                    userName = "Jin",
                    img_profile = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4",
                    img_contents = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FcdiIf5%2FbtqDsaeCxMV%2FbeY1EOcnnVBaXHVqyXOC5K%2Fimg.png"
                )
            )
            add(
                InstaData(
                    userName = "Su",
                    img_profile = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fd44x6A%2Fbtqzu7dKbZ6%2FlOoGM6j0rjWD3p8kKfB8ck%2Fimg.jpg",
                    img_contents = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FcdiIf5%2FbtqDsaeCxMV%2FbeY1EOcnnVBaXHVqyXOC5K%2Fimg.png"
                )
            )
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }

}

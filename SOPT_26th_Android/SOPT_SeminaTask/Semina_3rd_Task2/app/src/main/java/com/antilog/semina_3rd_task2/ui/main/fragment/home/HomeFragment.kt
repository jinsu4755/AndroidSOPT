package com.antilog.semina_3rd_task2.ui.main.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration

import com.antilog.semina_3rd_task2.R
import com.antilog.semina_3rd_task2.data.home_fragment.HomeData
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var homeAdapter: HomeAdapter
    val datas = mutableListOf<HomeData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val decoration = DividerItemDecoration(context, LinearLayout.VERTICAL)
        rv_home.addItemDecoration(decoration)

        homeAdapter = HomeAdapter(view.context)
        rv_home.adapter = homeAdapter
        loadDatas()
    }

    private fun loadDatas() {
        datas.apply {
            add(
                HomeData(
                    userName = "Park",
                    img_profile = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fd44x6A%2Fbtqzu7dKbZ6%2FlOoGM6j0rjWD3p8kKfB8ck%2Fimg.jpg",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
            add(
                HomeData(
                    userName = "Jin",
                    img_profile = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
            add(
                HomeData(
                    userName = "Su",
                    img_profile = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fd44x6A%2Fbtqzu7dKbZ6%2FlOoGM6j0rjWD3p8kKfB8ck%2Fimg.jpg",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
            add(
                HomeData(
                    userName = "Park",
                    img_profile = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fd44x6A%2Fbtqzu7dKbZ6%2FlOoGM6j0rjWD3p8kKfB8ck%2Fimg.jpg",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
            add(
                HomeData(
                    userName = "Jin",
                    img_profile = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
            add(
                HomeData(
                    userName = "Su",
                    img_profile = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fd44x6A%2Fbtqzu7dKbZ6%2FlOoGM6j0rjWD3p8kKfB8ck%2Fimg.jpg",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
            add(
                HomeData(
                    userName = "Park",
                    img_profile = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fd44x6A%2Fbtqzu7dKbZ6%2FlOoGM6j0rjWD3p8kKfB8ck%2Fimg.jpg",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
            add(
                HomeData(
                    userName = "Jin",
                    img_profile = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
            add(
                HomeData(
                    userName = "Su",
                    img_profile = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fd44x6A%2Fbtqzu7dKbZ6%2FlOoGM6j0rjWD3p8kKfB8ck%2Fimg.jpg",
                    img_contents = "https://avatars0.githubusercontent.com/u/45380072?s=460&u=46ee2e7073f0c5a0232a7420e769c683ed6ff61b&v=4"
                )
            )
        }
        homeAdapter.datas = datas
        homeAdapter.notifyDataSetChanged()
    }
}

package com.antilog.semina_2nd_task2

import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mainAdapter: MainAdapter
    val datas = mutableListOf<MainData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //기본적으로 RecyclerView를 나눌때 사용한다.
        val decoration = DividerItemDecoration(applicationContext, VERTICAL)
        rv_main.addItemDecoration(decoration)
        /*rv_main.addItemDecoration(MyDecoration(100, Color.BLACK))*/

        mainAdapter = MainAdapter(this.applicationContext)
        rv_main.adapter = mainAdapter
        loadData()
    }

    private fun loadData() {
        datas.apply {
            add(
                MainData(
                    content = "hello",
                    img = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbAgsOK%2FbtqDsPgZkxY%2FlUEDPZOjT4bl0QrKlLWxnk%2Fimg.png"
                )
            )
            add(
                MainData(
                    content = "hello2",
                    img = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbAgsOK%2FbtqDsPgZkxY%2FlUEDPZOjT4bl0QrKlLWxnk%2Fimg.png"
                )
            )
            add(
                MainData(
                    content = "hello3",
                    img = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbAgsOK%2FbtqDsPgZkxY%2FlUEDPZOjT4bl0QrKlLWxnk%2Fimg.png"
                )
            )
            add(
                MainData(
                    content = "hello4",
                    img = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbAgsOK%2FbtqDsPgZkxY%2FlUEDPZOjT4bl0QrKlLWxnk%2Fimg.png"
                )
            )
        }
        mainAdapter.datas = datas
        mainAdapter.notifyDataSetChanged()

    }
}

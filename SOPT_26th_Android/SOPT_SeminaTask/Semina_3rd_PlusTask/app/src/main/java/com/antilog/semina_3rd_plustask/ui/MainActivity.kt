package com.antilog.semina_3rd_plustask.ui

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.antilog.semina_3rd_plustask.R
import com.antilog.semina_3rd_plustask.data.Document
import com.antilog.semina_3rd_plustask.data.ResponseBook
import com.antilog.semina_3rd_plustask.network.RequestToServer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mainAdapter: MainAdapter

    var queryString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search()
    }

    private fun loadData() {
        RequestToServer.service.requestSearchBook(
            getString(R.string.app_key),
            queryString
        ).enqueue(object : Callback<ResponseBook> {
            override fun onFailure(call: Call<ResponseBook>, t: Throwable) {
                Log.d("Network:getList", "통신 실패")
            }

            override fun onResponse(call: Call<ResponseBook>, response: Response<ResponseBook>) {
                if (response.isSuccessful) {
                    Log.d("Network:getList", "통신 성공")
                    response.body()?.let {
                        setAdapter(it.documents)
                    }
                }
            }

        })
    }
    private fun setAdapter(documents: List<Document>) {
        Log.d("Network:getList", "어뎁터")
        mainAdapter = MainAdapter(documents, this)
        rv_book_list.adapter = mainAdapter
    }

    private fun search() {
        sv_search.setOnKeyListener(View.OnKeyListener{v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                Log.d("Network:getList", "어뎁터")
                queryString = sv_search.text.toString()
                loadData()
                return@OnKeyListener false
            }
            false
        })
    }
}

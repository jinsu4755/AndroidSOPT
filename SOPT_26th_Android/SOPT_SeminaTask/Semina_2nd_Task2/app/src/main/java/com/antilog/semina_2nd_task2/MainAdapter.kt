package com.antilog.semina_2nd_task2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainViewHolder>() {

    var datas = mutableListOf<MainData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_item, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}
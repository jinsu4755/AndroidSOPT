package com.antilog.semina_3rd_task2.ui.main.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antilog.semina_3rd_task2.R
import com.antilog.semina_3rd_task2.data.home_fragment.HomeData

class HomeAdapter (private val context: Context) : RecyclerView.Adapter<HomeViewHolder>() {

    var datas = mutableListOf<HomeData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.home_item,parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}

package com.antilog.semina_3rd_plustask.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antilog.semina_3rd_plustask.R
import com.antilog.semina_3rd_plustask.data.Document

class MainAdapter(var datas: List<Document>, private val context: Context) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.book_item,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}
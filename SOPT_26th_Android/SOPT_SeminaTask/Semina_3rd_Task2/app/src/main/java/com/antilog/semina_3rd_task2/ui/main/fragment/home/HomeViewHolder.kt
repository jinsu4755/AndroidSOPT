package com.antilog.semina_3rd_task2.ui.main.fragment.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.antilog.semina_3rd_task2.R
import com.antilog.semina_3rd_task2.data.home_fragment.HomeData
import com.bumptech.glide.Glide

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_username = itemView.findViewById<TextView>(R.id.tv_username)
    val img_profile = itemView.findViewById<ImageView>(R.id.img_profile)
    val img_contents = itemView.findViewById<ImageView>(R.id.img_contents)

    fun bind(homeData: HomeData) {
        tv_username.text = homeData.userName
        Glide.with(itemView).load(homeData.img_profile).into(img_profile)
        Glide.with(itemView).load(homeData.img_contents).into(img_contents)
    }
}
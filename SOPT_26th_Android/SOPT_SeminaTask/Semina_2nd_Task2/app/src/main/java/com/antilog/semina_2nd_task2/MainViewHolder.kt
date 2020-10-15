package com.antilog.semina_2nd_task2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text_content = itemView.findViewById<TextView>(R.id.text_content)
    val img_image = itemView.findViewById<ImageView>(R.id.img_image)

    fun bind(mainData: MainData) {
        text_content.text = mainData.content
        Glide.with(itemView).load(mainData.img).into(img_image)
    }

}
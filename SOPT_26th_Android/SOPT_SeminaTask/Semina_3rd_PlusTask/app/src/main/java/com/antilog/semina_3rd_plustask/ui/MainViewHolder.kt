package com.antilog.semina_3rd_plustask.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.antilog.semina_3rd_plustask.R
import com.antilog.semina_3rd_plustask.data.Document
import com.bumptech.glide.Glide

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img_book = itemView.findViewById<ImageView>(R.id.img_book_image)
    val tv_book_name = itemView.findViewById<TextView>(R.id.tv_book_name)
    val tv_book_content = itemView.findViewById<TextView>(R.id.tv_book_content)

    fun bind(customData: Document) {
        Glide.with(itemView).load(customData.thumbnail).into(img_book)
        tv_book_name.text = customData.title
        tv_book_content.text = customData.contents
    }
}
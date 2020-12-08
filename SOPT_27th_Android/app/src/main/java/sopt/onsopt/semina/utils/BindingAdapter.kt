package sopt.onsopt.semina.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import sopt.onsopt.semina.R

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("android:image_binding")
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(R.drawable.loading)
            .error(R.drawable.no_image)
            .into(imageView)
    }
}
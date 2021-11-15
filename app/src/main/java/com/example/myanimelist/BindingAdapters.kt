package com.example.myanimelist

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrlPath: String?) {
    val imgUrl = "https://image.tmdb.org/t/p/w500$imgUrlPath"
    imgUrl?.let {
        val imgUri = it
            .toUri()
            .buildUpon()
            .scheme("https")
            .build()

        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.ic_loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}
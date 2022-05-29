package com.damla.vlmediaproject.util

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.damla.vlmediaproject.R

fun ImageView.downloadFromURL(url: String?, placeholderprogressBar: CircularProgressDrawable) {
    val option = RequestOptions.placeholderOf(placeholderprogressBar).error(R.mipmap.ic_launcher)
    Glide.with(context).setDefaultRequestOptions(option).load(url)
        .into(this)
}

@SuppressLint("ResourceAsColor")
fun placeHolderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = placeHolder.STROKE_WIDTH
        centerRadius = placeHolder.CENTER_RADIUS
        start()
    }
}

@Suppress("ClassNaming")
object placeHolder{
    const val STROKE_WIDTH = 8f
    const val CENTER_RADIUS = 40f
}
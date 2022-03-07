package kg.example.homework3.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.glide(image:String){
    Glide.with(this).load(image).into(this)
}
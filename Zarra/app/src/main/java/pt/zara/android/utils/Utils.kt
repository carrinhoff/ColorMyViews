package pt.coolseg.android.utils

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.loadImage(uri: String?) {

    // this refere-se a imageview
    Glide.with(this.context)
        .load(uri)
        .placeholder(this.drawable)
        .centerInside()
        .into(this)
}


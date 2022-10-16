package com.hakvardanyan.imageslider

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.helper.widget.Carousel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class MainActivity : AppCompatActivity() {

    var images = arrayOf(
        "https://images.pexels.com/photos/1545743/pexels-photo-1545743.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg?cs=srgb&dl=pexels-pixabay-210019.jpg&fm=jpg",
        "https://images.pexels.com/photos/305070/pexels-photo-305070.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg?cs=srgb&dl=pexels-pixabay-210019.jpg&fm=jpg",
        "https://images.pexels.com/photos/305070/pexels-photo-305070.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCarousel()
    }

    private fun setupCarousel() {
        val carousel = findViewById<Carousel>(R.id.carousel) ?: return

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int = images.size

            override fun populate(view: View, index: Int) {
                if (view is AppCompatImageView) {
                    Glide.with(view)
                        .load(images[index])
                        .transform(CenterCrop(), RoundedCorners(25))
                        .into(view)
                }
            }

            override fun onNewItem(index: Int) = Unit
        })
    }
}

package com.example.imageswitcher

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher

class MainActivity : AppCompatActivity() {

    lateinit var imageSwitcher: ImageSwitcher
    lateinit var btnNext:Button
    lateinit var btnBack:Button
    lateinit var arrImage:IntArray
    var position:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSwitcher = findViewById(R.id.imageSwitch)
        btnNext = findViewById(R.id.nextButton)
        btnBack = findViewById(R.id.backButton)

        arrImage = intArrayOf(R.drawable.a,R.drawable.sawan,R.drawable.sqlite,R.drawable.notification,R.drawable.ttos)

        imageSwitcher.setFactory {
            val imageView = ImageView(applicationContext)
            imageView.scaleType= ImageView.ScaleType.FIT_CENTER
            imageView
        }
        btnBack.setOnClickListener {
            if (position>0)
            {
                position -=1
                imageSwitcher.setImageResource(arrImage[position])

            }
        }
        btnNext.setOnClickListener {
            if (position<arrImage.size)
            {
                position += 1
                imageSwitcher.setImageResource(arrImage[position])
            }
        }
    }
}
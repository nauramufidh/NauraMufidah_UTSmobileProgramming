package com.example.utsmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val imageView: ImageView = findViewById(R.id.imageView)
        val titleView: TextView = findViewById(R.id.titleView)
        val descriptionView: TextView = findViewById(R.id.descriptionView)

        val imageResId = intent.getIntExtra("imageResId", R.drawable.ic_launcher_foreground)
        val title = intent.getStringExtra("title")?: "News Title"
        val description = intent.getStringExtra("description") ?: "News Description"

        imageView.setImageResource(imageResId)
        titleView.text = title
        descriptionView.text = description
    }
}

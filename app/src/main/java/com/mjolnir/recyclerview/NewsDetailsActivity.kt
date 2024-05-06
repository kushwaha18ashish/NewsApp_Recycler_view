package com.mjolnir.recyclerview

import android.content.res.Resources
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val DtImage=findViewById<ImageView>(R.id.ivNewsImage)
        val DtHeading=findViewById<TextView>(R.id.tvNewsDetailHeading)
        val DtContent=findViewById<TextView>(R.id.tvNewsDetails)

        DtHeading.text=intent.getStringExtra("newsHeading")
        DtImage.setImageResource(intent.getIntExtra("newsImgId",R.drawable.news1))
        DtContent.text=intent.getStringExtra("newsDetails")
    }
}
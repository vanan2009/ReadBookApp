package com.example.readbookapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LikedBooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liked_books)
        title = "Liked Books"
    }
}

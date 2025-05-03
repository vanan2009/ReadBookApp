package com.example.readbookapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CommentedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commented)
        title = "Commented"
    }
}

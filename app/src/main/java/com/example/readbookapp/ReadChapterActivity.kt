package com.example.readbookapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.readbookapp.R

class ReadChapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_chapter)

        // Lấy tên chương từ Intent
        val chapterName = intent.getStringExtra("CHAPTER_NAME")

        // Hiển thị tên chương trong TextView
        val chapterTextView = findViewById<TextView>(R.id.chapterTextView)
        chapterTextView.text = "Đang đọc: $chapterName"

        // TODO: Thêm nội dung chương vào đây (có thể lấy dữ liệu từ database hoặc file)
    }
}

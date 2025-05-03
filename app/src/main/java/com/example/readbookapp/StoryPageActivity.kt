package com.example.readbookapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color

class StoryPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storypage)

        // Nút quay lại
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Quay lại activity trước
        }

        // Danh sách chương (giả lập dữ liệu)
        val chapters = listOf(
            "Chương 1: Khởi đầu",
            "Chương 2: Thức tỉnh",
            "Chương 3: Sức mạnh bạo chúa",
            "Chương 4: Đối đầu quái thú",
            "Chương 5: Thống trị Tokyo"
        )

        val chapterLayout = findViewById<LinearLayout>(R.id.linearChapters)

        for (chapter in chapters) {
            // Tạo TextView chương
            val textView = TextView(this)
            textView.text = chapter
            textView.textSize = 16f
            textView.setPadding(16, 12, 16, 12)
            textView.setBackgroundColor(Color.WHITE)
            textView.setTextColor(Color.BLACK)

            // Click: hiện thông báo
            textView.setOnClickListener {
                Toast.makeText(this, "Đang mở: $chapter", Toast.LENGTH_SHORT).show()
                // TODO: Intent chuyển qua đọc chương
            }

            chapterLayout.addView(textView)

            // Thêm đường viền (divider)
            val divider = View(this)
            divider.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 1
            )
            divider.setBackgroundColor(Color.BLACK)
            chapterLayout.addView(divider)
        }
    }
}

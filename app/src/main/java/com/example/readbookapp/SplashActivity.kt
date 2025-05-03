package com.example.readbookapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hiển thị layout Splash Screen
        setContentView(R.layout.activity_splash)

        // Sử dụng Handler để chuyển đến LoginActivity sau 2 giây
        Handler().postDelayed({
            // Chuyển đến LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Đảm bảo rằng SplashActivity không được quay lại
        }, 2000) // 2000ms = 2 giây
    }
}

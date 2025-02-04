package com.example.nativeandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openFlutterButton = findViewById<Button>(R.id.openFlutter)

        openFlutterButton.setOnClickListener {
            val intent = FlutterActivity.createDefaultIntent(this)
            startActivity(intent)
        }
    }
}

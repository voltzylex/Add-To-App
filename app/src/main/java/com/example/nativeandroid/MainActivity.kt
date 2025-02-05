package com.example.nativeandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.nativeandroid.ui.login.LoginActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openFlutterButton = findViewById<Button>(R.id.openFlutter)

        openFlutterButton.setOnClickListener {
//            val intent = FlutterActivity.createDefaultIntent(this)
//            startActivity(intent)
            var flutterEngine = FlutterEngine(this)
            flutterEngine.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
    FlutterEngineCache.getInstance().put("my_engine",flutterEngine)
            val login = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(login)
        }


    }
}

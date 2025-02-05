package com.example.nativeandroid.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nativeandroid.databinding.ActivityLoginBinding
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class LoginActivity : AppCompatActivity() {
    // Define the channel name for communication with Flutter
    private val CHANNEL = "login_channel"
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using view binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val cache = FlutterEngineCache.getInstance().get("my_engine")
            binding.login.isEnabled = true;
        // Set up the login button click listener
        binding.login.setOnClickListener {
            // Retrieve text from username and password fields.
            val usernameText = binding.username.text.toString()
            val passwordText = binding.password.text.toString()
            if(cache != null){
                // Create a MethodChannel using the cached engine's binary messenger.
                val channel = MethodChannel(cache.dartExecutor.binaryMessenger, CHANNEL)

                // Send login credentials to Flutter via the method channel.
                channel.invokeMethod("login", mapOf(
                    "username" to usernameText,
                    "password" to passwordText
                ))
                val flutterIntent = FlutterActivity.withCachedEngine("my_engine").build(this)
                startActivity(flutterIntent)
            }

            // Initialize a FlutterEngine and execute the default Dart entry point.
            //        val flutterEngine = FlutterEngine(this)
            //        flutterEngine.dartExecutor.executeDartEntrypoint(
            //            DartExecutor.DartEntrypoint.createDefault()
            //        )
            //        // Cache the engine with a key "my_engine" for later use.
            //        FlutterEngineCache.getInstance().put("my_engine", flutterEngine)
                        // Launch FlutterActivity using the cached engine.
            //            val flutterIntent = FlutterActivity.withCachedEngine("my_engine").build(this)
            //            startActivity(flutterIntent)
        }
    }
}

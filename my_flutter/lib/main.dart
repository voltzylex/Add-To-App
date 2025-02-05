import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  // Create the MethodChannel with the same channel name as on the native side.

  static const platform = MethodChannel("login_channel");

  // Variables to store received login data.
  String? _username;
  String? _password;

  @override
  void initState() {
    super.initState();
    // Set up a listener to receive login data.
    platform.setMethodCallHandler(_handleNativeMethod);
  }

  Future<void> _handleNativeMethod(MethodCall call) async {
    if (call.method == "login") {
      // Extract login data from the arguments.
      final args = call.arguments as Map;
      setState(() {
        _username = args["username"];
        _password = args["password"];
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Module',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter Module Screen (For login data from Native Screen)'),
        ),
        body: Center(
          child: _username != null
              ? Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text('Welcome, $_username!'),
                    const SizedBox(height: 8),
                    Text('Your password is: $_password'),
                  ],
                )
              : const Text('No login data received.'),
        ),
      ),
    );
  }
}

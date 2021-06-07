package com.example.clipboard

import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val channel = "clipboard.yingyj.com/clipboard"

    private fun getClipboardData(): String {
        return  ""
    }

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channel)
            .setMethodCallHandler{
                call, result ->
                // Note: this method is invoked on the main thread.
                // TODO
                if(call.method == "getClipboardData") {
                    val data = getClipboardData()

                    result.success(data)
                } else {
                    // todo log
                    result.notImplemented()
                }
            }
    }
}

package io.github.anandpc.testapp2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num1 = 0
        var num2 = 0
        var doAddition = false
        val result: Int
        val bundle = intent.extras

        if (bundle != null) {
            num1 = bundle.getInt("NUM_1")
            num2 = bundle.getInt("NUM_2")
            doAddition = bundle.getBoolean("DO_ADDITION")
        }

        result = if (doAddition) {
            num1 + num2
        } else {
            num1 - num2
        }

        val returnIntent = Intent()
        returnIntent.putExtra("RESULT", result.toString())
        setResult(RESULT_OK, returnIntent)
        finish()
    }
}
package kz.yerbol.myapplication7_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var tvPin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPin = findViewById(R.id.tv_pin)
    }

    fun enterChar(view: View) {
        val clickedBtn = view as Button
        tvPin.text = StringBuilder().append(tvPin.text).append(clickedBtn.text)
    }

    fun removeLastChar(view: View) {
        val pin = tvPin.text
        if (pin.isEmpty()) return
        tvPin.text = pin.dropLast(1)
    }

    fun checkPin(view: View) {
        if (!tvPin.text.equals("1567")) return
        Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
    }
}
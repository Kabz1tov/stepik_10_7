package kz.yerbol.myapplication7_5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var tvPin: TextView
    private val KEY_PIN = "key_pin"
    private val KEY_TV_PIN_COLOR = "key_tv_pin_color"

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
        if (tvPin.text.equals("1567")) {
            tvPin.setTextColor(Color.GREEN)
            Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SecondActivity::class.java))
        } else {
            tvPin.setTextColor(Color.RED)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_PIN, tvPin.text.toString())
        outState.putInt(KEY_TV_PIN_COLOR, tvPin.currentTextColor)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tvPin.text = savedInstanceState.getString(KEY_PIN)
        tvPin.setTextColor(savedInstanceState.getInt(KEY_TV_PIN_COLOR))
    }
}
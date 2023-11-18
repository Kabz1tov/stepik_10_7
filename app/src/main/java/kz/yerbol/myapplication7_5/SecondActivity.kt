package kz.yerbol.myapplication7_5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun share(view: View) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        startActivity(Intent.createChooser(sendIntent, "Title"))
    }

    fun sendByMail(view: View) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            data = Uri.parse("mailto:")
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            putExtra(Intent.EXTRA_SUBJECT, "This is my subject.")
            putExtra(Intent.EXTRA_EMAIL, arrayOf("somemail@gmail.com"))
        }

        startActivity(Intent.createChooser(sendIntent, "Choose Email Client..."))
    }

    fun call(view: View) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_DIAL
            data = Uri.parse("tel:" + "8344814819")
        }

        startActivity(sendIntent)
    }

    fun openCamera(view: View) {
        val sendIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(sendIntent)
    }
}
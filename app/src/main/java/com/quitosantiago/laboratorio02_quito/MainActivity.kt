package com.quitosantiago.laboratorio02_quito

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greenView: View = findViewById(R.id.greenView)
        val buttonShow: Button = findViewById(R.id.buttonShow)
        val buttonHide: Button = findViewById(R.id.buttonHide)

        buttonShow.setOnClickListener {
            showGreenView(greenView)
        }

        buttonHide.setOnClickListener {
            hideGreenView(greenView)
        }
    }

    private fun showGreenView(view: View) {
        view.visibility = View.VISIBLE
    }

    private fun hideGreenView(view: View) {
        view.visibility = View.GONE
    }
}
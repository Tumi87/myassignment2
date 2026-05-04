package com.example.lifehackapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val scoreImage = findViewById<ImageView>(R.id.scoreImage)

        val (message, imageRes) = if (score >= 5) {
            "Captain Legend!💪" to R.drawable.high_score
        } else {
            "Drowning Sailor oh no!" to R.drawable.low_score
        }


        scoreText.text = "Treasures discovered: $score / $total \n$message"
        scoreImage.setImageResource(imageRes)

        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }
    }
}


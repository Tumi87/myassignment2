package com.example.lifehackapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ReviewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val layout =findViewById<LinearLayout>(R.id.reviewLayout)

        val questions = arrayOf(
            "Their heart is located in their thorax , which is inside their head!",
            "They can change gender depending on what is best for their environment.",
            "They can produce 600+ volts of electricity!",
            "Jellyfish are actually 95% water! They have no bones,brain , or blood.",
            "Killer whales (orcas) frequently kill people in the wild",
            "Octopuses have three hearts and blue blood",
            "Dolphins don't have ears",

            )

        val answers = arrayOf(true, true, true, false, false, true, false)

        for (i in questions.indices) {
            val tv = TextView(this)
            val answerText = if (answers[i]) "deep truth" else "tale false"
            tv.text = "${questions[i]}\nAnswer: $answerText\n"
            tv.setPadding(0,0,0,20)
            tv.textSize= 16f
            tv.setTypeface(null,Typeface.BOLD)
            tv.setTextColor(Color.WHITE)
            layout.addView(tv)

        }
    }
}


package com.example.lifehackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    var index = 0
    var score = 0
    lateinit var questionText: TextView
    lateinit var feedbackText: TextView
    val questions = arrayOf(
        "Is a shrimp's heart located in its thorax/head?",
        "Can oysters change their gender?",
        "Can electric eels produce 600+ volts of electricity?",
        "Are jellyfish made of 50% water?",
        "Do killer whales frequently kill people in the wild?",
        "Do octopuses have three hearts and blue blood?",
        "Do dolphins have external ear flaps?",
    )

    val answers = arrayOf(true, true, true, false, false, true, false)

    val explanations = arrayOf(
        "Fact: Their thorax, which is inside their head!",
        "Fact: They can change gender depending on what is best for their environment.",
        "Fact: They can produce 600+ volts of electricity!",
        "Myth: Jellyfish are actually 95% water! They have no bones,brain , or blood yoh.",
        "Myth: There are no records of fatal attacks by orcas in the wild.",
        "Fact: Octopuses really do have three hearts and blue blood!",
        "Myth: Dolphins have small ear openings behind their eyes but no external ear flaps.",
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val hackButton = findViewById<Button>(R.id.hackButton)
        val mythButton = findViewById<Button>(R.id.mythButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        loadQuestion()

        hackButton.setOnClickListener { checkAnswer(true) }
        mythButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            index++

            if (index < questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }
    fun loadQuestion() {
        questionText.text = questions[index]
    }

    fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            feedbackText.text = "full sail! 🎉\n${explanations[index]}"
            score++
        } else {
            feedbackText.text = "tsunami alert!!!❌\n${explanations[index]}"
        }
    }
}

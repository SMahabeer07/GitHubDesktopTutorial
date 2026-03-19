package com.fake.gradecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var etMark: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvGrade: TextView
    lateinit var symbol: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etMark = findViewById(R.id.etText)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvGrade = findViewById(R.id.tvGrade)

        btnCalculate.setOnClickListener{
            val mark = etMark.text.toString().toIntOrNull()

            val grade = mark?.let { it1 ->
                if (it1 >= 80) {
                    "A"
                } else if (mark >= 70) {
                    "B"
                } else if (mark >= 60) {
                    "C"
                } else if (mark >= 50) {
                    "D"
                } else {
                    "F"
                }
            }

            tvGrade.text = "Your grade is: $grade"
        }

        Snackbar.make(findViewById(android.R.id.content), R.string.enter_a_mark_between_1_and_100, Snackbar.LENGTH_SHORT).show()

    }

    private fun getRemark(grade: String): String {
        return when (grade) {
            "A" -> "Excellent work! Keep it up."
            "B" -> "Great job, almost at the top!"
            "C" -> "Good effort, but you can do better."
            "D" -> "Needs more focus and practice."
            "F" -> "Please see me after class for extra help."
            else -> "Invalid grade."
        }
    }

    private fun getLetterGrade(score: Int): String {
        return if (score >= 90) {
            "A"
        } else if (score >= 80) {
            "B"
        } else if (score >= 70) {
            "C"
        } else if (score >= 60) {
            "D"
        } else {
            "F"
        }
    }

    fun getGrade(score: Int): String {
        return when (score) {
            in 90..100 -> "A+"
            in 80..89 -> "A"
            in 70..79 -> "B"
            in 60..69 -> "C"
            in 50..59 -> "D"
            in 0..49 -> "F"
            else -> "Invalid Score"
        }
    }
}
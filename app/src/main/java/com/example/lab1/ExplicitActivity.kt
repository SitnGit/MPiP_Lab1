package com.example.lab1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ExplicitActivity : AppCompatActivity() {

    private lateinit var btnVoRed: Button
    private lateinit var btnOtkazi: Button
    private lateinit var textInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        btnVoRed = findViewById(R.id.btnVoRed)
        btnOtkazi = findViewById(R.id.btnOtkazi)
        textInput = findViewById(R.id.input)

        btnVoRed.setOnClickListener{ _ ->
            Intent().let { intent ->
                intent.putExtra("textInput",textInput.text.toString())
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }

        btnOtkazi.setOnClickListener{ _ ->
            Intent().let { intent ->
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }

    }
}
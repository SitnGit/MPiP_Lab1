package com.example.lab1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var btnExplicit: Button
    private lateinit var btnImplicit: Button
    private lateinit var btnActionSend: Button
    private lateinit var btnImage: Button

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            val data: Intent? = result.data
            textView.text = data?.getStringExtra("textInput")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        btnExplicit = findViewById(R.id.btnExplicit)
        btnImplicit = findViewById(R.id.btnImplicit)
        btnActionSend = findViewById(R.id.btnActionSend)
        btnImage = findViewById(R.id.btnImage)

        btnExplicit.setOnClickListener {
            Intent(this, ExplicitActivity::class.java).let { i ->
                resultLauncher.launch(i)
            }
        }

        btnImplicit.setOnClickListener{ _ ->
            Intent().apply {
                action = "mk.ukim.finki.mpip.IMPLICIT_ACTION"
                type = "text/plain"
            }.let { intent ->
                startActivity(Intent.createChooser(intent,"Choose the app for your intent"))
            }
        }

        btnActionSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND).let { emailIntent ->
                emailIntent.type = "text/plain"
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MPiP Send Title")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Content send from MainActivity")
                startActivity(emailIntent)
            }
        }


        btnImage.setOnClickListener {
            val photoIntent = Intent(Intent.ACTION_SEND).let { photoIntent ->
                photoIntent.type = "image/jpg"
                startActivity(photoIntent)
            }
        }

    }


}
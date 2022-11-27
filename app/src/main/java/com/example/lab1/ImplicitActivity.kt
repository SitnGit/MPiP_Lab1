package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class ImplicitActivity : AppCompatActivity() {

    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        val arrayAdapter: ArrayAdapter<*>
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        val pkgAppsList = packageManager.queryIntentActivities(mainIntent, 0)

        var activities = arrayOf<String>()
        for (i in pkgAppsList.indices) {
            activities += pkgAppsList[i].activityInfo.name
        }

        var list = findViewById<ListView>(R.id.ImplicitList)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, activities)
        list.adapter = arrayAdapter

    }
}
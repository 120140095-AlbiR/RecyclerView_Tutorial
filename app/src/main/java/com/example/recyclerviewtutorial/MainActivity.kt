package com.example.recyclerviewtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val json = resources.openRawResource(R.raw.users)
            .bufferedReader().use { it.readText() }

        val type = object : TypeToken<List<User>>() {}.type
        val userList: List<User> = Gson().fromJson(json, type)

        users.addAll(userList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(users)

    }
}
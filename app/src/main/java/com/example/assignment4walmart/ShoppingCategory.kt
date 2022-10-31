package com.example.assignment4walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val bundle = intent.extras
        val email = bundle!!.getString("user", "")
        initView(email)

    }

    fun initView(email: String) {
        var emailTextView: TextView = findViewById(R.id.email)
        emailTextView.text = email
    }

    fun onclick_image(imageView: View) {
        Toast.makeText(
            this,
            "You have chosen the " + imageView.contentDescription + " category of shopping",
            Toast.LENGTH_LONG
        ).show()
    }
}
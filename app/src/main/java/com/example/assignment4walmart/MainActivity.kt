package com.example.assignment4walmart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private var users = ArrayList<User>()
    private lateinit var emailAddress: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.add(User("Ritesh", "Maharjan", "ritesh", "ritesh", "ritesh@gmail.com"))
        users.add(User("Rajendra", "Maharjan", "rajendra", "rajendra", "rajendra@gmail.com"))
        users.add(User("Rakesh", "Maharjan", "rakesh", "rakesh", "rakesh@gmail.com"))
        users.add(User("Sudip", "Adhikari", "sudip", "sudip", "sudip@gmail.com"))
        users.add(User("Bibek", "Thokar", "bibek", "bibek", "bibek@gmail.com"))

        initView()
    }

    fun initView() {
        emailAddress = findViewById(R.id.emailId)
        password = findViewById(R.id.password)
    }

    fun btn_signIn(view: View) {
        users.forEach {
            if (it.email == emailAddress.text.toString() && it.password == password.text.toString()) {
                startActivity(Intent(this, ShoppingCategory::class.java).apply {
                    putExtra("user", it.email)
                })

            }
        }
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: User = result.data?.extras?.get("user") as User
                users.add(data)
            }
        }

    fun onclick_createaccount(view: View) {
        resultLauncher.launch(Intent(this, Register::class.java))
    }
}
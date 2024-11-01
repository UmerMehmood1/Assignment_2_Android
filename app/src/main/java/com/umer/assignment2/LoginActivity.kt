package com.umer.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private var etUsername: EditText? = null
    private var etPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnSignup = findViewById<Button>(R.id.btnSignup)

        btnLogin.setOnClickListener {
            val username = etUsername?.text.toString()
            val password = etPassword?.text.toString()
            if (isValidCredentials(username, password)) {
                val intent = Intent(
                    this@LoginActivity,
                    ExpenseTrackerActivity::class.java
                )
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Invalid username or password!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnSignup.setOnClickListener {
            val intent = Intent(
                this@LoginActivity,
                SignupActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        for (user in users) {
            if (user[0] == username && user[1] == password) {
                return true
            }
        }
        return false
    }

    companion object {
        private val users = ArrayList<Array<String>>()

        fun addUser(username: String, password: String) {
            users.add(arrayOf(username, password))
        }
    }
}
package com.umer.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SignupActivity : AppCompatActivity() {
    private var etNewUsername: EditText? = null
    private var etNewPassword: EditText? = null
    private var etConfirmPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etNewUsername = findViewById(R.id.etNewUsername)
        etNewPassword = findViewById(R.id.etNewPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val username = etNewUsername?.text.toString()
            val password = etNewPassword?.text.toString()
            val confirmPassword = etConfirmPassword?.text.toString()
            if (password == confirmPassword) {
                LoginActivity.addUser(username, password)
                Toast.makeText(
                    this,
                    "Signup successful! Please log in.",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(
                    this@SignupActivity,
                    LoginActivity::class.java
                )
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

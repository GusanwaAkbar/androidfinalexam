package com.example.mgafinalexam.pages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mgafinalexam.databinding.ActivityLoginBinding
import com.example.mgafinalexam.model.LoginResponse
import com.example.mgafinalexam.utils.PrefManager

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        checkLoginAvailability()

        loginViewModel.isLoading.value = false
        loginViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        binding.button.setOnClickListener {
            val requestBody = mapOf(
                "username" to binding.editTextTextEmailAddress.text.toString(),
                "password" to binding.editTextTextPassword.text.toString()
            )

            loginViewModel.onLogin(this, requestBody, ({ response: LoginResponse? ->
                if (response?.success == true) {
                    Log.d("response succes", response.message ?: "")
                    val data = response.data
                    val token = "Bearer ${data!!.token}"
                    PrefManager.saveToken(this@Login, token)
                    val intent = Intent(this@Login, Home::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }
            }))
        }
    }
    private fun checkLoginAvailability() {
        val token = PrefManager.getToken(this@Login)
        if (token != null){
            val intent = Intent(this@Login, Home::class.java)
            startActivity(intent)
        }
    }
}
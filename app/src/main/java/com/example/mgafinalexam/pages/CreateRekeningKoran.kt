package com.example.mgafinalexam.pages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mgafinalexam.databinding.ActivityCreateRekeningKoranBinding

class CreateRekeningKoran : AppCompatActivity() {
    lateinit var binding: ActivityCreateRekeningKoranBinding
    private val createRekeningViewModel: CreateRekeningKoranViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateRekeningKoranBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        createRekeningViewModel.isLoading.value = false
        createRekeningViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        binding.button.setOnClickListener {
            val requestBody = mapOf(
                "namaRekeningKoran" to binding.editTextNamaRekeningKoran.text.toString(),
            )

            createRekeningViewModel.onCreateRekeningKoran(
                this,
                requestBody,
                ({ response: Boolean? ->
                    if (response == true) {
                        Log.d("response succes", "Success" ?: "")
                        Toast.makeText(
                            this,
                            "Data Added Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@CreateRekeningKoran, Home::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                    }
                })
            )
        }
    }
}
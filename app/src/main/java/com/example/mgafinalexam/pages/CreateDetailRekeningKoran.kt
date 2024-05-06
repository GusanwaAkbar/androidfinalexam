package com.example.mgafinalexam.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mgafinalexam.databinding.ActivityCreateDetailRekeningKoranBinding

class CreateDetailRekeningKoran : AppCompatActivity() {
    lateinit var binding: ActivityCreateDetailRekeningKoranBinding
    private val createDetailRekeningKoranViewModel: CreateDetailRekeningKoranViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateDetailRekeningKoranBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        createDetailRekeningKoranViewModel.isLoading.value = false
        createDetailRekeningKoranViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        val id = intent.getIntExtra("id", 0)

        binding.button.setOnClickListener {
            val requestBody = mapOf(
                "deskripsi" to binding.editTextDescription.text.toString(),
                "nominal" to binding.editTextNominal.text.toString()
                )

            createDetailRekeningKoranViewModel.onCreateDetailRekeningKoran(
                this,
                id,
                requestBody,
                ({ response: Boolean? ->
                    if (response == true) {
                        Log.d("response succes", "Success" ?: "")
                        Toast.makeText(
                            this,
                            "Data Added Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@CreateDetailRekeningKoran, Home::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                    }
                })
            )
        }
    }
}
package com.example.mgafinalexam.pages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mgafinalexam.adapter.RekeningKoranAdapter
import com.example.mgafinalexam.databinding.ActivityHomeBinding
import com.example.mgafinalexam.model.RekeningKoranResponse
import com.example.mgafinalexam.utils.PrefManager


class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        homeViewModel.isLoading.value = false
        homeViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        homeViewModel.getRekeningKoran(this, ({ response: RekeningKoranResponse? ->
            if (response?.success == true) {
                Log.d("response succes", response.message)
                val data = response.data
                if (data?.size!! > 0) {
                    binding.rvRekeningKoran.adapter = RekeningKoranAdapter(data, this@Home)
                }
            }else{
                Toast.makeText(this, "Data Rekening Koran kosong", Toast.LENGTH_SHORT).show()
            }
        }))

        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this, CreateRekeningKoran::class.java)
            startActivity(intent)
        }

        binding.floatingActionButton2.setOnClickListener{
            PrefManager.deleteToken(this@Home)
            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@Home, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
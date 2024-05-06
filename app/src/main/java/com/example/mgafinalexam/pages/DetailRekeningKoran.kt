package com.example.mgafinalexam.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mgafinalexam.adapter.RekeningKoranDetailAdapter
import com.example.mgafinalexam.databinding.ActivityDetailRekeningKoranBinding
import com.example.mgafinalexam.model.RekeningKoranDetailResponse

class DetailRekeningKoran : AppCompatActivity() {
    lateinit var binding: ActivityDetailRekeningKoranBinding
    private val detailRekeningKoranViewModel: DetailRekeningViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailRekeningKoranBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        detailRekeningKoranViewModel.isLoading.value = false
        detailRekeningKoranViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }




        val id = intent.getIntExtra("id", 0)
        val namaRekeningKoran = intent.getStringExtra("nama_rekening_koran")
        val createdBy = intent.getStringExtra("created_by")

        detailRekeningKoranViewModel.getRekeningKoranDetail(
            this,
            id,
            ({ response: RekeningKoranDetailResponse? ->
                if (response?.success == true) {
                    Log.d("response succes", response.message)
                    val data = response.data

                    binding.txtNamaRekeningKoran.text = namaRekeningKoran.toString()
                    binding.txtCreatedBy.text = createdBy.toString()

                    val dataChild = data.dataRekeningKoranList
                    if ((dataChild?.size ?: 0) > 0) {
                        binding.rvDetailRekeningKoran.adapter =
                            RekeningKoranDetailAdapter(dataChild, this@DetailRekeningKoran)
                    } else {
                        Toast.makeText(
                            this,
                            "Data Detail Rekening Koran kosong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        )

        binding.button2.setOnClickListener{
            val intent = Intent(this, CreateDetailRekeningKoran::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }
}
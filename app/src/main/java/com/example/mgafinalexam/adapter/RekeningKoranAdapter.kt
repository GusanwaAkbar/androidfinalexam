package com.example.mgafinalexam.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mgafinalexam.pages.DetailRekeningKoran
import com.example.mgafinalexam.databinding.RekeningKoranItemBinding
import com.example.mgafinalexam.model.RekeningKoranData

class RekeningKoranAdapter(val data: List<RekeningKoranData?>?, val c:Context): RecyclerView .Adapter<RekeningKoranAdapter.RekeningKoranAdapterHolder>(){
    class RekeningKoranAdapterHolder(val binding: RekeningKoranItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: RekeningKoranData?, c: Context){
            binding.txtNamaRekeningKoran.text = data?.namaRekeningKoran
            binding.txtCreatedBy.text = "Created by : ${data?.createdBy}"

            binding.root.setOnClickListener {
                val intent = Intent(c, DetailRekeningKoran::class.java)
                intent.putExtra("id", data?.id)
                intent.putExtra("nama_rekening_koran", data?.namaRekeningKoran)
                intent.putExtra("created_by", data?.createdBy)

                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RekeningKoranAdapterHolder {
        val binding = RekeningKoranItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RekeningKoranAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: RekeningKoranAdapterHolder, position: Int) {
        holder.bind(data?.get(position), c)
    }

    override fun getItemCount() = data?.size ?: 0
}
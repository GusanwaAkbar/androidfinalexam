package com.example.mgafinalexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mgafinalexam.databinding.RekeningKoranDetailItemBinding
import com.example.mgafinalexam.model.DataRekeningKoranDetailChild

class RekeningKoranDetailAdapter(val data: List<DataRekeningKoranDetailChild?>?, val c:Context): RecyclerView .Adapter<RekeningKoranDetailAdapter.RekeningKoranDetailAdapterHolder>(){
    class RekeningKoranDetailAdapterHolder(val binding: RekeningKoranDetailItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataRekeningKoranDetailChild?, c: Context){
            binding.txtId.text = "#" + data?.id.toString()
            binding.txtNominal.text = "Nominal : " + data?.nominal.toString()
            binding.txtDeskripsi.text = "Deskripsi : " + data?.deskripsi
            binding.txtVerifikasi.text = "Verifikasi : " + data?.verifikasi
            binding.txtChecker1.text = "Checker : " + data?.checker1.toString()
            binding.txtChecker2.text = "Checker : " + data?.checker2.toString()

//            binding.root.setOnClicgokListener {
//                val intent = Intent(c, DetailRekeningKoran::class.java)
//                intent.putExtra("id", data?.id)
//                binding.root.context.startActivity(intent)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RekeningKoranDetailAdapterHolder {
        val binding = RekeningKoranDetailItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RekeningKoranDetailAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: RekeningKoranDetailAdapterHolder, position: Int) {
        holder.bind(data?.get(position), c)
    }

    override fun getItemCount() = data?.size ?: 0
}
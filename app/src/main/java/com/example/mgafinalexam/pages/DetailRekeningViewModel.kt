package com.example.mgafinalexam.pages

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mgafinalexam.model.RekeningKoranDetailResponse
import com.example.mgafinalexam.network.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRekeningViewModel (application: Application) : AndroidViewModel(application)  {
    val isLoading = MutableLiveData<Boolean>()
    fun getRekeningKoranDetail(context: Context, id: Int, onResponse: (RekeningKoranDetailResponse?) -> Unit) {
        isLoading.value = true
        NetworkModule.service(context).getRekeningKoranDetail(id)
            .enqueue(object : Callback<RekeningKoranDetailResponse> {
                override fun onResponse(
                    call: Call<RekeningKoranDetailResponse>,
                    response: Response<RekeningKoranDetailResponse>
                ) {
                    isLoading.value = false
                    onResponse(response.body())
                }

                override fun onFailure(call: Call<RekeningKoranDetailResponse>, t: Throwable) {
                    isLoading.value = false
                    onResponse(null)
                }
            })
    }
}
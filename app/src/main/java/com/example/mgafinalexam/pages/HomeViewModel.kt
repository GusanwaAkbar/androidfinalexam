package com.example.mgafinalexam.pages

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mgafinalexam.model.RekeningKoranResponse
import com.example.mgafinalexam.network.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel (application: Application) : AndroidViewModel(application) {
    val isLoading = MutableLiveData<Boolean>()
    fun getRekeningKoran(context: Context, onResponse: (RekeningKoranResponse?) -> Unit) {
        isLoading.value = true
        NetworkModule.service(context).getRekeningKoran()
            .enqueue(object : Callback<RekeningKoranResponse> {
                override fun onResponse(
                    call: Call<RekeningKoranResponse>,
                    response: Response<RekeningKoranResponse>
                ) {
                    isLoading.value = false
                    onResponse(response.body())
                }

                override fun onFailure(call: Call<RekeningKoranResponse>, t: Throwable) {
                    isLoading.value = false
                    onResponse(null)
                }
            })
    }
}
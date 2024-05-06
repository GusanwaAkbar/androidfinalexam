package com.example.mgafinalexam.pages

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mgafinalexam.network.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreateDetailRekeningKoranViewModel(application: Application) : AndroidViewModel(application) {
    val isLoading = MutableLiveData<Boolean>()

    fun onCreateDetailRekeningKoran(context: Context, id: Int, requestBody: Map<String, String>, onResponse: (Boolean?) -> Unit) {
        isLoading.value = true
        NetworkModule.service(context).createRekeningKoranDetail(requestBody, id)
            .enqueue(object : Callback<Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    isLoading.value = false
                    onResponse(response.isSuccessful)
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    isLoading.value = false
                    onResponse(null)
                }
            })
    }
}

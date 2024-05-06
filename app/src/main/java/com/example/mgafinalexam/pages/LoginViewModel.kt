package com.example.mgafinalexam.pages

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mgafinalexam.model.LoginResponse
import com.example.mgafinalexam.network.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val isLoading = MutableLiveData<Boolean>()

    fun onLogin(context: Context, requestBody: Map<String, String>, onResponse: (LoginResponse?) -> Unit) {
        isLoading.value = true
        NetworkModule.service(context).login(requestBody)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    isLoading.value = false
                    onResponse(response.body())
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    isLoading.value = false
                    onResponse(null)
                }
            })
    }
}

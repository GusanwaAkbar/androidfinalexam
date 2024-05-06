package com.example.mgafinalexam.network

import com.example.mgafinalexam.model.LoginResponse
import com.example.mgafinalexam.model.RekeningKoranDetailResponse
import com.example.mgafinalexam.model.RekeningKoranResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("/api/auth0/login/v1")
    fun login(@Body requestBody: Map<String, String>): Call<LoginResponse>

    @GET("/rekening-koran/all")
    fun getRekeningKoran(): Call<RekeningKoranResponse>

    @GET("/rekening-koran/{id}")
    fun getRekeningKoranDetail(
        @Path("id") id: Int
    ): Call<RekeningKoranDetailResponse>

    @POST("/rekening-koran/")
    fun createRekeningKoran(@Body requestBody: Map<String, String>): Call<Void>

    @POST("/RekeningKoran/{id}")
    fun createRekeningKoranDetail(@Body requestBody: Map<String, String>, @Path("id") id: Int): Call<Void>

}
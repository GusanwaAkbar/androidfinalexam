package com.example.mgafinalexam.model
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data") var data: LoginData? = LoginData(),
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("status") var status: Int? = null,
)

data class LoginData(
    @SerializedName("token") var token: String? = null
)



package com.example.mgafinalexam.model
import com.google.gson.annotations.SerializedName

data class RekeningKoranResponse(
    @SerializedName("data") val data: List<RekeningKoranData>,
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("timestamp") val timestamp: Long
)

data class RekeningKoranData(
    @SerializedName("id") val id: Int,
    @SerializedName("namaRekeningKoran") val namaRekeningKoran: String,
    @SerializedName("created") val created: Long,
    @SerializedName("updated") val updated: Long,
    @SerializedName("createdBy") val createdBy: String,
    @SerializedName("updatedBy") val updatedBy: String,
    @SerializedName("done") val done: Boolean
)

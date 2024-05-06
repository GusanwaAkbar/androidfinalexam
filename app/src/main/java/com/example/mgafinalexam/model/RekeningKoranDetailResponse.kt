package com.example.mgafinalexam.model
import com.google.gson.annotations.SerializedName

data class RekeningKoranDetailResponse(
    @SerializedName("data") val data: RekeningKoranDetailData,
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("timestamp") val timestamp: Long
)

data class RekeningKoranDetailData(
    @SerializedName("number") val number: Int,
    @SerializedName("last") val last: Boolean,
    @SerializedName("numberOfElements") val numberOfElements: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("totalPages") val totalPages: Int,
    @SerializedName("pageable") val pageable: Pageable,
    @SerializedName("sort") val sort: Sort,
    @SerializedName("first") val first: Boolean,
    @SerializedName("dataRekeningKoranList") val dataRekeningKoranList: List<DataRekeningKoranDetailChild>,
    @SerializedName("totalElements") val totalElements: Int,
    @SerializedName("empty") val empty: Boolean
)

data class Pageable(
    @SerializedName("pageNumber") val pageNumber: Int,
    @SerializedName("paged") val paged: Boolean,
    @SerializedName("pageSize") val pageSize: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("sort") val sort: Sort,
    @SerializedName("unpaged") val unpaged: Boolean
)

data class Sort(
    @SerializedName("empty") val empty: Boolean,
    @SerializedName("unsorted") val unsorted: Boolean,
    @SerializedName("sorted") val sorted: Boolean
)

data class DataRekeningKoranDetailChild(
    @SerializedName("id") val id: Int,
    @SerializedName("nominal") val nominal: Double,
    @SerializedName("deskripsi") val deskripsi: String,
    @SerializedName("verifikasi") val verifikasi: String,
    @SerializedName("checker1") val checker1: Boolean,
    @SerializedName("checker2") val checker2: Boolean,
    @SerializedName("created") val created: Long,
    @SerializedName("updated") val updated: Long,
    @SerializedName("createdBy") val createdBy: String?
)


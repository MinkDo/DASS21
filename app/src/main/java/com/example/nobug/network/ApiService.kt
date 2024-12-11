package com.example.nobug.network

import android.security.identity.ResultData
import com.example.nobug.data.model.FormData
import com.example.nobug.data.model.ResultResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @POST("/form")
    suspend fun submitForm(@Body formData: FormData): Response<ResultResponse>
}

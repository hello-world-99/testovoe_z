package com.test.testovoe_z

import com.test.testovoe_z.data_models.LoginRequest
import com.test.testovoe_z.data_models.LoginResponse
import com.test.testovoe_z.data_models.Payment
import com.test.testovoe_z.data_models.PaymentsResponse


import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("app-key: 12345", "v: 1")
    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @Headers("app-key: 12345", "v: 1")
    @GET("payments")
    suspend fun getPayments(@Header("token") token: String): Response<PaymentsResponse>
}
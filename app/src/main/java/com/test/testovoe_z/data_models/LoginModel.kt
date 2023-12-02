package com.test.testovoe_z.data_models

data class LoginRequest(val login: String, val password: String)
data class LoginResponse(val success: String, val response: TokenResponse?)
data class TokenResponse(val token: String)

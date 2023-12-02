package com.test.testovoe_z

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.testovoe_z.ui.theme.Testovoe_zTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Navigation()
        }
    }
}
 val apiService: ApiService by lazy {
    Retrofit.Builder()
        .baseUrl("https://easypay.world/api-test/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}


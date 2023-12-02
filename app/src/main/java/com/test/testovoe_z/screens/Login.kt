package com.test.testovoe_z.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.test.testovoe_z.ValueBuffer
import com.test.testovoe_z.apiService
import com.test.testovoe_z.data_models.LoginRequest
import com.test.testovoe_z.data_models.PaymentsResponse
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    var text by remember { mutableStateOf("") }

    val context = LocalContext.current
    val loginState = remember { mutableStateOf("demo") }
    val passwordState = remember { mutableStateOf("12345") }
    val scope = rememberCoroutineScope()





    Scaffold(Modifier.fillMaxSize()) {
            padding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ){
            Row( modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(bottom = 400.dp)
                .padding(horizontal = 50.dp)
                ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    TextField(
                        value = loginState.value,
                        onValueChange = { loginState.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Login") }
                    )
                    TextField(
                        value = passwordState.value,
                        onValueChange = { passwordState.value = it },
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Button(
                        onClick =
                        {
                            val login = loginState.value
                            val password = passwordState.value


                            // Perform login
                            scope.launch {
                                try {
                                    val response = apiService.login(LoginRequest(login, password))

                                    if (response.isSuccessful&&response.body()?.success=="true") {
                                        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                                        ValueBuffer.savedToken= response.body()?.response?.token.toString()


                                        val getPayments= apiService.getPayments(ValueBuffer.savedToken)
                                        ValueBuffer.listPayments= getPayments.body()?.response!!




                                        navController.navigate("payments screen")

                                    } else {
                                        Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                                    }
                                } catch (e: Exception) {

                                }
                            }

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    {
                        Text(text = "Login")
                    }

                }
            }


            }
    }




}


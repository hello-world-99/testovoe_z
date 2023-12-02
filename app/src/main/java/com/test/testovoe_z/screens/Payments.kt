package com.test.testovoe_z.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.test.testovoe_z.ValueBuffer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Payments(navController: NavController) {

    Scaffold(Modifier.fillMaxSize()) { padding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
               ) {

                items(ValueBuffer.listPayments) { item ->
                    Box(
                        Modifier

                            .padding(horizontal = 10.dp, vertical =5.dp )
                            .background(color = Color(245, 227, 255, 255), shape = RoundedCornerShape(8.dp))
                            .fillMaxSize()
                            .padding(padding)
                            .shadow(1.dp)
                            )
                        {
                        Column(Modifier

                            .padding(horizontal = 5.dp,vertical =5.dp )) {

                            Text(text = "id: ${item.id}")
                            Text(text = "title: ${item.title}")
                            Text(text = "amount: ${item.amount.toString()}")
                            Text(text = "created: ${item.created}")
                        }

                    }
                }
            }
        }
    }
}



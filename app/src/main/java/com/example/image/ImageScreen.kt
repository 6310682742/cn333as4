package com.example.image

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ImageScreen(
    navController:NavHostController,
    search:String? = "dog",
    width:Int? = 150,
    height:Int? = 150
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "This is your image",color = Color.Gray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
            DisplayImage(src = "https://loremflickr.com/$width/$height/$search")
            Text(
                modifier = Modifier.clickable {
                    navController.popBackStack()
                },
                text = "$width x $height $search",
                color = Color.Gray,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Back To Home Screen")
            }
        }

    }
}
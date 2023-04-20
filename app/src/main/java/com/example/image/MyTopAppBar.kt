package com.example.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.image.ui.theme.ImageTheme

@Composable
fun MyTopAppBar(appName:String = "Random Image") {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(64.dp)
        .background(Color.Blue)
        .padding(6.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(text = appName, fontSize = 22.sp, fontWeight = FontWeight.Bold,color = Color.Green)
    }
}
@Preview
@Composable
fun Preview(){
    ImageTheme{
        MyTopAppBar()

    }
}
package com.example.image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    var search by remember {
        mutableStateOf("")
    }
    var width by remember {
        mutableStateOf(0)
    }
    var height by remember {
        mutableStateOf(0)
    }
    var error by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()){
        MyTopAppBar()
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Enter your image, width, height", fontSize = 18.sp, textAlign = TextAlign.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp))
                TextField(

                    value = search,
                    onValueChange = { newSearch->search = newSearch },
                    label = { Text("Image") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done),
                )
                TextField(
                    value = width.toString(),
                    onValueChange = { newSearch->width = newSearch.toInt() },
                    label = { Text("Width") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done),
                )
                TextField(
                    value = height.toString(),
                    onValueChange = { newSearch->height = newSearch.toInt() },
                    label = { Text("Height") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done),
                )
                Text(text = error, color = Color.Red)
                Button(onClick = {
                    if(search.isBlank() or search.isEmpty()) {
                        error = "search can not be empty"
                    }
                    if(width == 0) {
                        error = "width can not be 0"
                    }
                    if(height == 0) {
                        error = "width can not be 0"
                    }
                    else {
                        navController.navigate("image_screen/$width/$height/$search")
                    }
                }) {
                    Text(text = "Go!")
                }
                Row() {
                    Button(onClick = { search = "fish" },modifier = Modifier.padding(6.dp)) {
                        Text(text = "fish")
                    }
                    Button(onClick = { search = "dog" },modifier = Modifier.padding(6.dp)) {
                        Text(text = "dog")
                    }
                    Button(onClick = { search = "cat" },modifier = Modifier.padding(6.dp)) {
                        Text(text = "cat")
                    }
                }
            }
        }
    }

}


package com.example.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.image.ui.theme.ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column {
                        Row {
                            DisplayImage("https://i.pinimg.com/originals/b8/0f/70/b80f70409611cbb9ec27aecd96c59f4e.jpg")
                            DisplayImage("https://img.republicworld.com/republic-prod/stories/promolarge/xhdpi/1nwxihtbpg7hc6co_1623921163.jpeg")
                        }
                        Row {
                            DisplayImage("https://www.thesprucepets.com/thmb/hxWjs7evF2hP1Fb1c1HAvRi_Rw0=/2765x0/filters:no_upscale():strip_icc()/chinese-dog-breeds-4797219-hero-2a1e9c5ed2c54d00aef75b05c5db399c.jpg")
                            DisplayImage("https://i.pinimg.com/550x/56/e5/3b/56e53bd754deedf4254a8172e0f7d580.jpg")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayImage(src: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(src)
            .crossfade(true)
            .build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
                    .clip(CircleShape)
                    .size(200.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageTheme {
//        DisplayImage()
    }
}

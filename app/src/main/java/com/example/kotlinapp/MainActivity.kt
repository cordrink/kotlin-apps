package com.example.kotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinapp.ui.theme.KotlinAppTheme

data class Artwork(val imageRes: Int, val title: String, val name: String, val year: String)

val artworks = listOf(
    Artwork(R.drawable.ic_launcher_background, "Page de demarrage", "Artiste 1", "2021"),
    Artwork(R.drawable.cover, "Tech ou toc ?", "Fabrice Zerah", "2024"),
    Artwork(R.drawable.cover_old1, "Le Manuel de l'anonymat", "Doxxeur", "2024"),
    Artwork(R.drawable.cover_old2, "Petit guide de survie face a l'IA", "Michaudet, amelie", "2024")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }

    fun changeArtwork(increment: Int) {
        currentIndex = (currentIndex + increment).let {
            when {
                it < 0 -> artworks.size - 1
                it >= artworks.size -> 0
                else -> it
            }
        }
    }

    val currentArtwork = artworks[currentIndex]

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Row(modifier = modifier) {
            GreetingImage(imageRes = currentArtwork.imageRes)
        }
        Row(modifier = modifier) {
            GreetingText(title = currentArtwork.title, name = currentArtwork.name, year = currentArtwork.year)
        }
        Row(modifier = modifier) {
            GreetingButton(
                onPreviousClick = { changeArtwork(-1) },
                onNextClick = { changeArtwork(1) }
            )
        }
    }
}

@Composable
fun GreetingImage(imageRes: Int) {
    Column(modifier = Modifier.padding(16.dp).shadow(elevation = 16.dp, shape = RoundedCornerShape(8.dp))) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
    }
}

@Composable
fun GreetingText(title: String, name: String, year: String) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 25.sp
        )
        Row {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = " ($year)",
                color = Color.Gray.copy(alpha = 0.9f),
            )
        }
    }
}

@Composable
fun GreetingButton(onPreviousClick: () -> Unit, onNextClick: () -> Unit) {
    Row {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.padding(8.dp).width(110.dp).height(32.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.padding(8.dp).width(110.dp).height(32.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinAppTheme {
        Greeting()
    }
}
package com.example.kotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinapp.ui.theme.KotlinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = message, fontSize = 100.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(text = from, fontSize = 36.sp, modifier = Modifier.padding(8.dp).align(alignment = Alignment.CenterHorizontally))
    }
}

@Composable
fun GreetingImage(subtitle: String, title: String, message: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = title,
            fontSize = 25.sp,
            modifier = Modifier.padding(16.dp),
        )
        Text(
            text = subtitle,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
        Text(
            text = message,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    KotlinAppTheme {
        GreetingImage(
            title = "Jetpack Compose tutorial",
            subtitle = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            message = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
    }
}
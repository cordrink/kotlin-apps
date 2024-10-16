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
import androidx.compose.ui.text.font.FontWeight
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
                    GreetingImage(
                        title = "All tasks cmpleted",
                        message = "Nice work!"
                    )
                }
            }
        }
    }
}

/*@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = message, fontSize = 100.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(text = from, fontSize = 36.sp, modifier = Modifier.padding(8.dp).align(alignment = Alignment.CenterHorizontally))
    }
}*/

@Composable
fun GreetingImage(title: String, message: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
//            modifier = Modifier.size(50.dp)
        )
        Text(
            text = title,
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 8.dp,
            ),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify,
            fontSize = 16.sp,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    KotlinAppTheme {
        GreetingImage(
            title = "All tasks cmpleted",
            message = "Nice work!"
        )
    }
}
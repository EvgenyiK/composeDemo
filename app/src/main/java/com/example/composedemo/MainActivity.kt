package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DemoTextPreview() {
    ComposeDemoTheme {
        DemoScreen()
    }
}

@Composable
fun DemoText(message: String, fontSize: Float) {
    Text(
        text = message, fontSize = fontSize.sp, fontWeight = FontWeight.Bold
    )
}

@Composable
fun DemoSlider(sliderPosition: Float, onPositionChange: (Float) -> Unit) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..38f,
        value = sliderPosition,
        onValueChange = { onPositionChange(it) })
}

@Composable
fun DemoScreen() {
    var sliderPosition by remember { mutableStateOf(20f) }

    val handlePositionChange = { position: Float -> sliderPosition = position }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        DemoText(message = "Welcome to Compose", fontSize = sliderPosition)
        Spacer(modifier = Modifier.height(150.dp))
        DemoSlider(
            sliderPosition = sliderPosition, onPositionChange = handlePositionChange
        )
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = sliderPosition.toInt().toString() + "sp"
        )
    }
}
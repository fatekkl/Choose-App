package com.proa.chooseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.proa.chooseapp.ui.theme.ChooseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChooseAppTheme {
                Surface(
                    color = Color(0xFF424242),
                    modifier = Modifier.fillMaxSize()
                ) {
                    var random by remember {
                        mutableIntStateOf(0)
                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("O que você vai comer?", color = Color.White)
                        Button(onClick = { random = (0..5).random() }) {
                            Text("Sortear")
                        }
                        Text(
                            text = when (random) {
                                1 -> "Arroz e Feijão"
                                2 -> "Feijoada"
                                3 -> "Sushi"
                                4 -> "Pizza"
                                5 -> "Hamburguer"
                                else -> "Comida"
                            },
                            color = Color.White
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChooseAppTheme {
        Greeting("Android")
    }
}
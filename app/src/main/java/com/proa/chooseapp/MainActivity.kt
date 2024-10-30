package com.proa.chooseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        mutableIntStateOf(1)
                    }

                    val choose = when (random) {
                        1 -> "Arroz e Feijão"
                        2 -> "Batata Frita"
                        3 -> "Sushi"
                        4 -> "Pizza"
                        5 -> "Hamburguer"
                        else -> "Arroz e Feijão"
                    }

                    val image = when (random) {
                        1 -> R.drawable.arroz_feijao
                        2 -> R.drawable.batata_frita
                        3 -> R.drawable.sushi
                        4 -> R.drawable.pizza
                        5 -> R.drawable.hamburguer
                        else -> R.drawable.arroz_feijao
                    }


                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text("O que você vai comer?", color = Color.White, fontSize = 30.sp)


                        Text(
                            text = choose,
                            color = Color.White,
                            fontSize = 30.sp,
                            modifier = Modifier.padding(top = 80.dp)
                        )

                        Image(
                            painter = painterResource(image),
                            contentDescription = "Filme",
                            modifier = Modifier
                                .width(225.dp).height(250.dp)
                                .padding(bottom = 8.dp).clip(shape = RoundedCornerShape(10.dp))
                        )

                        Button(onClick = { random = (1..5).random() }, modifier = Modifier.size(width = 200.dp, height = 50.dp)) {
                            Text("Sortear", fontSize = 25.sp)
                        }



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
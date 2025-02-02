package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier.background(Color.Black).fillMaxSize().wrapContentSize(Alignment.Center))
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember {mutableIntStateOf(1)}
    val imageResource = when (result) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        else -> R.drawable.dice6
    }
    val textResource = when (result) {
        1 -> "ONE"
        2 -> "TWO"
        3 -> "THREE"
        4 -> "FOUR"
        5 -> "FIVE"
        else -> "SIX"
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Dice Roll Game",
            fontSize = 80.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center,
            color = Color.Cyan,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Click the 'Roll' button below to roll the dice.",
            fontSize = 15.sp,
            lineHeight = 15.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(bottom = 100.dp, start = 40.dp, end = 40.dp)
        )
        Text(
            text = textResource,
            fontSize = 30.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp, bottom = 20.dp)
        )
        Image(painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }, modifier = Modifier.padding(top = 10.dp)) {
            Text(text = stringResource(R.string.roll))
        }
    }
}
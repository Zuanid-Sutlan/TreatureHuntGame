package com.example.treaturehuntgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.treaturehuntgame.ui.theme.TreatureHuntGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreatureHuntGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGameUi()
                }
            }
        }
    }
}

@Composable
fun CaptainGameUi(){
    val treasureFound = remember { mutableIntStateOf(0) }
    val currentDirection = remember { mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth(),
        Arrangement.Top, Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Treasure Hunt Game", fontSize = 24.sp, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(80.dp))
        Text(text = "Treasure Found: ${treasureFound.intValue}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Current Direction towards: ${currentDirection.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stormOrTreasure.value)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier, Arrangement.Center) {
            OutlinedButton(onClick = {
                currentDirection.value = "East"
                if (Random.nextBoolean()){
                    treasureFound.intValue += 1
                    stormOrTreasure.value = "Found Treasure"
                }else{
                    stormOrTreasure.value = "Storm Ahead!!"
                }
            }) {
                Text(text = "Go to the East")
            }
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedButton(onClick = {
                currentDirection.value = "West"
                if (Random.nextBoolean()){
                    treasureFound.intValue += 1
                    stormOrTreasure.value = "Found Treasure"
                }else{
                    stormOrTreasure.value = "Storm Ahead!!"
                }
            }) {
                Text(text = "Go to the West")
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier, Arrangement.Center) {
            OutlinedButton(onClick = {
                currentDirection.value = "South"
                if (Random.nextBoolean()){
                    treasureFound.intValue += 1
                    stormOrTreasure.value = "Found Treasure"
                }else{
                    stormOrTreasure.value = "Storm Ahead!!"
                }
            }) {
                Text(text = "Go to the South")
            }
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedButton(onClick = {
                currentDirection.value = "North"
                if (Random.nextBoolean()){
                    treasureFound.intValue += 1
                    stormOrTreasure.value = "Found Treasure"
                }else{
                    stormOrTreasure.value = "Storm Ahead!!"
                }
            }) {
                Text(text = "Go to the North")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TreatureHuntGameTheme {
        CaptainGameUi()
    }
}
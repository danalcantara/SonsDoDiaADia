package com.example.soundtherapy

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.sonsparaodiaadia.ui.theme.SonsParaODiaAdiaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SonsParaODiaAdiaTheme {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    var selectedMission by remember { mutableStateOf("") }

    when (selectedMission) {
        "Baby Sleep" -> BabySleepScreen(onBack = { selectedMission = "" })
        "Study Focus" -> StudyFocusScreen(onBack = { selectedMission = "" })
        "Yoga and Meditation" -> YogaMeditationScreen(onBack = { selectedMission = "" })
        else -> MissionSelectionScreen(onMissionSelected = { selectedMission = it })
    }
}

@Composable
fun MissionSelectionScreen(onMissionSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Choose a Mission", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onMissionSelected("Baby Sleep") }, modifier = Modifier.fillMaxWidth()) {
            Text("Sono do Bebê")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onMissionSelected("Study Focus") }, modifier = Modifier.fillMaxWidth()) {
            Text("Foco nos Estudos")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onMissionSelected("Yoga and Meditation") }, modifier = Modifier.fillMaxWidth()) {
            Text("Yoga e Meditação")
        }
    }
}

@Composable
fun BabySleepScreen(onBack: () -> Unit) {
    SoundControlScreen(
        title = "Sono do Bebê",
        sounds = listOf("Ruído Branco", "Chuva", "Vento"),
        onBack = onBack
    )
}

@Composable
fun StudyFocusScreen(onBack: () -> Unit) {
    SoundControlScreen(
        title = "Foco nos Estudos",
        sounds = listOf("Cafeteria", "Floresta", "Biblioteca"),
        onBack = onBack
    )
}

@Composable
fun YogaMeditationScreen(onBack: () -> Unit) {
    SoundControlScreen(
        title = "Yoga e Meditação",
        sounds = listOf("Água Corrente", "Pássaros", "Vento Suave"),
        onBack = onBack
    )
}

@Composable
fun SoundControlScreen(title: String, sounds: List<String>, onBack: () -> Unit) {
    var selectedSound by remember { mutableStateOf<String?>(null) }
    var volume by remember { mutableStateOf(0.5f) }
    var timer by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(title, fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onBack) {
                Text("Voltar")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(sounds.size) { index ->
            val sound = sounds[index]
            Button(
                onClick = { selectedSound = sound },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(sound)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Volume")
            Slider(value = volume, onValueChange = { volume = it })
            Spacer(modifier = Modifier.height(16.dp))

            Text("Timer (minutos)")
            Slider(value = timer.toFloat(), onValueChange = { timer = it.toInt() }, valueRange = 0f..120f)
            Spacer(modifier = Modifier.height(16.dp))

            if (selectedSound != null) {
                Text("Reproduzindo: $selectedSound", fontSize = 16.sp)
            }
        }
    }
}

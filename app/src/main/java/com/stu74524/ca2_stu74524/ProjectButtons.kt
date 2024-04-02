package com.stu74524.ca2_stu74524

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ToHomeButton(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Home")
    }
}

@Composable
fun ToScreen1Button(onClick: () -> Unit){
    ElevatedButton(onClick = { onClick() }) {
        Text("Show Film")
    }
}

@Composable
fun ToScreen2Button(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Show Film")
    }
}

@Composable
fun ToScreen3Button(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Show Film")
    }
}

@Composable
fun ToScreen4Button(onclick: () -> Unit) {
    ElevatedButton(onClick = {onclick() }) {
        Text("Show Film")
    }
}
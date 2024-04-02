package com.stu74524.ca2_stu74524


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen4(navController: NavController) {
    val seatsRemaining = remember { mutableStateOf(Random.nextInt(0, 16)) }
    val seatsSelected = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate("${Routes.HomeScreen.route}/${seatsSelected.value.toString()}")
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Add Seat",
                        )
                    }
                },
                title = {
                    Text("Catch me if you can",
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFADC9EB))
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.catchmfifyoucan),
                    contentDescription = "Movie preview",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight(0.6f),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(
                        fontSize = 30.sp,
                        text = "Catch me if you can",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        fontSize = 16.sp,
                        text = "Starring:",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text(
                        fontSize = 16.sp,
                        text = " Leonardo Dicaprio, Tom Hanks",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    fontSize = 14.sp,
                    text = "An FBI agent pursues Frank Abagnale Jr., who, before turning 19, wrote millions in fraudulent checks while impersonating a Pan Am pilot, a doctor, and a prosecutor.",
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Select Seats",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(
                        onClick = {
                            if (seatsSelected.value > 0) {
                                seatsSelected.value--
                                seatsRemaining.value++
                            }
                        },
                        enabled = seatsSelected.value > 0
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Remove Seat",
                            tint = Color.Black
                        )
                    }
                    Text(
                        text = "${seatsSelected.value}",
                        color = Color.Black,
                    )
                    IconButton(
                        onClick = {
                            if (seatsRemaining.value > 0) {
                                seatsRemaining.value--
                                seatsSelected.value++
                            }
                        },
                        enabled = seatsRemaining.value > 0
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add Seat",
                            tint = if (seatsRemaining.value > 0) Color.Black else Color.Gray // Change tint based on availability
                        )
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    Text(
                        textAlign = TextAlign.End,
                        text = "${seatsRemaining.value} seats Remaining",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    )
}
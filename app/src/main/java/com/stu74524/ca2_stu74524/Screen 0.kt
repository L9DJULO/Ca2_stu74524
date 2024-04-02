package com.stu74524.ca2_stu74524

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

class Movie(
    val name: String,
    val image: Int,
    val certification: String,
    val description: String,
    val starring: List<String>,
    val runningTimeMins: Int,
    var seatsRemaining: Int,
    var seatsSelected: Int,
)

val movies = listOf(
    Movie(
        name = "Fight Club",
        image = R.drawable.fightclub,
        certification = "R",
        description = "A depressed insomniac (Edward Norton) meets Tyler Durden (Brad Pitt), a strange soap salesman. They form an underground club, fighting disillusioned men. Their partnership falters when Marla (Helena Bonham Carter) catches Tyler's eye.",
        starring = listOf("Brad Pitt", "Edward Norton"),
        runningTimeMins = 139,
        seatsRemaining =  Random.nextInt(0,16),
        seatsSelected = 0
    ),
    Movie(
        name = "Se7en",
        image = R.drawable.seven,
        certification = "R",
        description = "Detective Somerset (Morgan Freeman) and newcomer Mills (Brad Pitt) investigate gruesome murders tied to the seven deadly sins. Somerset befriends Mills' pregnant wife, Tracy (Gwyneth Paltrow), worried about raising a child in the crime-ridden city.",
        starring = listOf("Brad Pitt" , "Morgan Freeman"),
        runningTimeMins = 127,
        seatsRemaining = Random.nextInt(0,16),
        seatsSelected = 0
    ),
    Movie(
        name = "Forest Gump",
        image = R.drawable.forestgump,
        certification = "R",
        description = "Forrest Gump follows the journey of Forrest, a simple man with a big heart and low I.Q., who achieves remarkable success and impacts many lives, driven by his enduring love for childhood sweetheart Jenny, showcasing the power of love to overcome obstacles.",
        starring = listOf("Tom Hanks", "Robin Wright"),
        runningTimeMins = 127,
        seatsRemaining = Random.nextInt(0,16),
        seatsSelected = 0
    ),
    Movie(
        name = "Catch me if you can",
        image = R.drawable.catchmfifyoucan,
        certification = "R",
        description = "An FBI agent pursues Frank Abagnale Jr., who, before turning 19, wrote millions in fraudulent checks while impersonating a Pan Am pilot, a doctor, and a prosecutor.",
        starring = listOf("Leonardo Dicaprio", "Tom Hanks"),
        runningTimeMins = 127,
        seatsRemaining = Random.nextInt(0,16),
        seatsSelected = 0
    ),
)


@Composable
fun MovieBox(seats : Int,movie: Movie, buttonAction: () -> Unit) {
    movie.seatsSelected = seats
    Box(
        modifier = Modifier
            .height(300.dp)
            .width(185.dp)
            .background(color = Color(0xFFA2A9D3), shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontWeight = FontWeight(800),
                modifier = Modifier.padding(vertical = 4.dp),
                fontSize = 15.sp,
                text = movie.name,
                color = Color.White,
            )
            Image(modifier = Modifier.size(200.dp),painter = painterResource(id = movie.image), contentDescription ="Movie Preview" )
            if (movie.seatsSelected > 0) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "${movie.seatsSelected} seats Selected",
                    color = Color.Green,
                )
            }
            else{
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "${movie.seatsRemaining} seats Remaining",
                    color = Color.White,
                )
            }

            when (movies.indexOf(movie)) {
                0 -> ToScreen1Button(onClick = buttonAction)
                1 -> ToScreen2Button(onClick = buttonAction)
                2 -> ToScreen3Button(onClick = buttonAction)
                3 -> ToScreen4Button(onclick = buttonAction)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController , seats : Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            fontWeight = FontWeight.ExtraBold,
                            text = "Home page",
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        var MAMA = PaddingValues()
        MAMA = innerPadding
        Column(
            modifier = Modifier
                .background(color = Color(0xFFADC9EB))
                .padding(top = 40.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                movies.take(2).forEachIndexed { index, movie ->
                    MovieBox(movie = movie, seats = seats) {
                        when (index) {
                            0 -> navController.navigate(Routes.FirstScreen.route)
                            1 -> navController.navigate(Routes.SecondScreen.route)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                movies.drop(2).take(2).forEachIndexed { index, movie ->
                    MovieBox(movie = movie , seats = seats) {
                        when (index) {
                            0 -> navController.navigate(Routes.ThirdScreen.route)
                            1 -> navController.navigate(Routes.FourthScreen.route)
                        }
                    }
                }
            }
            Credits()
        }
    }
}

@Composable
fun Credits()
{
    Column()
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ){
            Text(text = "Credits: https://www.imdb.com/", color = Color.White)
        }
    }
}
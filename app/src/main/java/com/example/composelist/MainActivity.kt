package com.example.composelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelist.ui.theme.ComposelistTheme
import com.example.composelist.ui.theme.Shapes
import com.skydoves.landscapist.coil.CoilImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposelistTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    MovieList(listOf(Movie("SpiderMan","https://picsum.photos/200"),
        Movie("Hulk","https://picsum.photos/200")
    ))
}


@Composable
fun MovieList(messages: List<Movie>) {
    LazyColumn(  verticalArrangement = Arrangement.spacedBy(8.dp),) {
        items(messages) { movie ->
            MovieRow(movie)
        }
    }
}

@Composable
fun MovieRow(movie: Movie) {
    Surface(color = Color.LightGray) {
        Row (verticalAlignment = Alignment.CenterVertically,
         modifier = Modifier.fillMaxSize(),
        ){
            CoilImage(
                imageModel = movie.posterUrl,
                contentDescription = "movie poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(0.5f).clip(CircleShape)
            )
            Text(text = movie.name,color = Color.White,textAlign = TextAlign.Center)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposelistTheme {
        MainContent()
    }
}
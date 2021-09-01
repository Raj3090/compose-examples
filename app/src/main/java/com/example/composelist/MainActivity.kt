package com.example.composelist

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelist.ui.theme.ComposelistTheme
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
    //pass data from here
   val viewModel = MoviesViewModel()
   val movies=viewModel.movies.observeAsState()

    movies.value?.let {
        MovieList(it)
    }

}


@Composable
fun MovieList(messages: List<Movie>) {
    LazyColumn(  verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(messages) { movie ->
            MovieRow(movie)
        }
    }
}

@Composable
fun MovieRow(movie: Movie) {
    Surface(color = Color.LightGray) {
        Row (verticalAlignment = Alignment.CenterVertically,
         modifier = Modifier.fillMaxSize()
        ){
            CoilImage(
                imageModel = movie.posterUrl,
                contentDescription = "movie poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .clip(CircleShape)
                    .clickable {
//                        Toast.makeText(this,"image  clicked",Toast.LENGTH_SHORT)
                    }
                    .clip(CircleShape)
            )
            Text(text = movie.name,color = Color.White,textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(20.dp))
            ColouredCheckbox()
        }
    }
}

@Composable
fun ColouredCheckbox() {
    val isChecked = remember { mutableStateOf(false) }

    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { isChecked.value = it },
        enabled = true,
        colors = CheckboxDefaults.colors(Color.Blue)
    )
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposelistTheme {
        MainContent()
    }
}

package br.christian.martins.movie_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.christian.martins.movie_app.data.Movie
import br.christian.martins.movie_app.ui.theme.MovieappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList(
                        movies = listOf(
                            Movie(
                                title = "The Lord of the Rings - 1",
                            ),
                            Movie(
                                title = "The Lord of the Rings - 2",
                            ),
                            Movie(
                                title = "The Lord of the Rings - 3",
                            )
                        ),
                    )
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
    MovieappTheme {
        Greeting("Android")
    }
}

@Composable
fun MovieList(movies: List<Movie>) {
    Column {
        movies.forEach { movie ->
            MovieRow(movie)
        }
    }
}

@Composable
fun MovieRow(movie: Movie) {
    Text(
        text = "Movie ${movie.title}!"
    )
}
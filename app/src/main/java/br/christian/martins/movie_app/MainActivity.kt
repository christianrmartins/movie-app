package br.christian.martins.movie_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import br.christian.martins.movie_app.data.Movie
import br.christian.martins.movie_app.data.MovieAPI
import br.christian.martins.movie_app.ui.theme.MovieappTheme
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val movieApi by lazy {
        MovieAPI()
    }

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
            runAsync()
        }
    }

    private fun runAsync() {
        lifecycleScope.launch {
            println(movieApi.getMoviesT())
        }
    }

    override fun onDestroy() {
        movieApi.dispose()
        super.onDestroy()
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
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie)
        }
    }
    //OR
//    Column {
//        movies.forEach { movie ->
//            MovieRow(movie)
//        }
//    }
}

@Composable
fun MovieRow(movie: Movie) {
    Text(
        text = "Movie ${movie.title}!"
    )
}
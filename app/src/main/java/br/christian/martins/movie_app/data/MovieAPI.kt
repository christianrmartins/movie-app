package br.christian.martins.movie_app.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header

class MovieAPI {

    //    private val url = "https://api.themoviedb.org/"
    private val url = "https://ktor.io/"

    private val httpClient = HttpClient {
        defaultRequest {
            header("accept", "application/json")
        }
    }

    suspend fun testApi() = get("")

    suspend fun getMovies(page: Int = 1): List<Movie> {
        val response = get("3/movie/now_playing?language=en-US&page=$page")
        println(response.status)
        return listOf()
    }

    private suspend fun get(path: String) = httpClient.get(url + path)

    fun dispose() {
        httpClient.close()
    }

//    private suspend fun getMovies(page: Int) {
//        val client = HttpClient(CIO)
//        val response: HttpResponse = client.get("$url\"3/movie/now_playing?language=en-US&page=$page\"")
//        println(response.status)
//        client.close()
//    }

}
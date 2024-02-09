package br.christian.martins.movie_app.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get

class MovieAPI {

    private val url = "https://api.themoviedb.org/"
    private val httpClient = HttpClient(CIO)

    private suspend fun getMovies(page: Int = 1) {
        val response = get("3/movie/now_playing?language=en-US&page=$page")
        println(response.status)
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
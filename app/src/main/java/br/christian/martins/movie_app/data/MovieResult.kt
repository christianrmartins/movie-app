package br.christian.martins.movie_app.data

data class MovieResult(
    val results: List<Movie>,
    val page: Int,
    val totalPage: Int,
    val totalResults: Int,
)
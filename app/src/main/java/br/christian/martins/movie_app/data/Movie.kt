package br.christian.martins.movie_app.data

data class Movie(
    val id: Int,
    val title: String,
    val popularity: Int,
    val overview: String,
    val image: String,
)
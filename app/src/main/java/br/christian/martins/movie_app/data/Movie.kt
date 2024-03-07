package br.christian.martins.movie_app.data

data class Movie(
    val id: Int = 1,
    val title: String,
    val popularity: Double = 5.0,
    val overview: String = "",
    val image: String = "",
)
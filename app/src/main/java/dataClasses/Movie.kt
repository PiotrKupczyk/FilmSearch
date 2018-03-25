package dataClasses

/**
 * Created by piotrkupczyk on 24.03.2018.
 */

data class Movie(val id: Int, val title: String, val posterURL: String, val stars: Int,
                    val likes: Int, val geners: List<String>, val actorsIds: List<Int>,
                 val director: String, val descriptor: String) {
}
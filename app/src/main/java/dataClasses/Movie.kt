package dataClasses

import java.io.Serializable

/**
 * Created by piotrkupczyk on 24.03.2018.
 */

data class Movie(val id: Int, val title: String, val posterUrl: String, val stars: Int,
                    val likes: Int, val genres: List<String>, val actorsIds: List<Int>,
                 val director: String, val description: String):Serializable {

    fun genresToString():String {
        val result = StringBuilder()
        for (genre in genres)
            result.append("$genre, ")
        return result.toString().removeSuffix(", ")
    }
}
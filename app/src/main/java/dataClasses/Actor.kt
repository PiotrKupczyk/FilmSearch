package dataClasses

import java.io.Serializable

/**
 * Created by piotrkupczyk on 25.03.2018.
 */
data class Actor(val id: Int, val name: String, val imgUrl: String, val biography: String):Serializable {
}
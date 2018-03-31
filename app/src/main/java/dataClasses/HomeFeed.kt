package dataClasses

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by piotrkupczyk on 25.03.2018.
 */
data class HomeFeed(val movies: List<Movie>, val actors: List<Actor>):Serializable {
}
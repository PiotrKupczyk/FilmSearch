package fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.piotrkupczyk.filmsearch.R
import com.squareup.picasso.Picasso
import consts.Consts

class MovieImagesFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //it's just temporary
        val selectedMovieIndex = arguments.getInt(Consts.SELECTED_MOVIE_INDEX)
        val view = inflater?.inflate(R.layout.movie_images, container!!, false)
        val url = "https://images-na.ssl-images-amazon.com/images/M/MV5BYWY1ZWQ5YjMtMDE0MS00NWIzLWE1M2YtODYzYTk2OTNlYWZmXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_SY500_SX334_AL_.jpg"
        if (selectedMovieIndex % 2 == 0) {
            val image = view?.findViewById<ImageView>(R.id.imageView)!!
            Picasso.with(context).
                    load(url).
                    into(image)

        }
        return view
    }
}
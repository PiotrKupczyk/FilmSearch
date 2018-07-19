package adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.piotrkupczyk.filmsearch.MovieDetailsActivity
import com.example.piotrkupczyk.filmsearch.MovieScrollActivity
import com.example.piotrkupczyk.filmsearch.R
import com.squareup.picasso.Picasso
import dataClasses.HomeFeed
import kotlinx.android.synthetic.main.movie_row.view.*

/**
 * Created by piotrkupczyk on 24.03.2018.
 */
class MovieAdapter(private val homeFeed: HomeFeed,private val context: Context) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return homeFeed.movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_row, parent, false)

        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        if (holder != null) {
            holder.view.movieTitle.text = homeFeed.movies[position].title
            holder.view.movieCategory.text = homeFeed.movies[position].genresToString()

            //load movie from Picasso library
            val moviePoster = holder.view.movieImage
            Picasso.with(holder.view.context).load(homeFeed.movies[position].posterUrl)
                    .into(moviePoster)

            holder.view.movieRow.setOnClickListener {
                MovieDetailsActivity.start(context, position, homeFeed)
            }
        }
    }

    fun removeAt(position: Int) {
        homeFeed.movies.removeAt(position)
        notifyItemRemoved(position)

    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}
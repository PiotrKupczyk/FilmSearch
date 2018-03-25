package adapters

import android.graphics.Movie
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.piotrkupczyk.filmsearch.R

/**
 * Created by piotrkupczyk on 24.03.2018.
 */
class MovieAdapter(val dataSource: ArrayList<Movie>) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_row, parent, false)

        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        if (holder != null) {
//            holder.view.movieCategory = dataSource.get(position)
        }
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}
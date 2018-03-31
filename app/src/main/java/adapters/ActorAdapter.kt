package adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.piotrkupczyk.filmsearch.R
import com.squareup.picasso.Picasso
import dataClasses.Actor
import dataClasses.HomeFeed
import kotlinx.android.synthetic.main.actor_row.view.*
import kotlinx.android.synthetic.main.movie_row.view.*

class ActorAdapter(private val dataSource: HomeFeed, private val moviePosition: Int) : RecyclerView.Adapter<CustomViewHolder>() {

    private val actorsIds = dataSource.movies[moviePosition].actorsIds

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.actor_row, parent, false)

        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return actorsIds.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val actors = getActors()

        if (holder != null) {
            holder.view.actorName.text = actors[position].name

            //load movie from Picasso library
            val actorProfile = holder.view.actorImage
            Picasso.with(holder.view.context).load(actors[position].imgUrl)
                    .into(actorProfile)
        }
    }

    fun getActors(): List<Actor> {
        lateinit var actors: MutableList<Actor>

        for (actorId in actorsIds)
            actors.add(dataSource.actors[actorId])

        return actors
    }

}
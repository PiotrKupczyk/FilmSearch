package fragments

import adapters.ActorAdapter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.piotrkupczyk.filmsearch.R
import consts.Consts
import dataClasses.HomeFeed

class ActorsRecyclerViewFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val homeFeed = arguments.getSerializable(Consts.HOME_FEED) as HomeFeed
        val selectedMovieIndex = arguments.getInt(Consts.SELECTED_MOVIE_INDEX)
        val view = inflater?.inflate(R.layout.actors, container!!, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.actorsRecyclerView)!!
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ActorAdapter(homeFeed, selectedMovieIndex)
        return view
    }
}
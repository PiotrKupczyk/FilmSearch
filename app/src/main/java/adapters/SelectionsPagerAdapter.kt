package adapters

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import consts.Consts
import dataClasses.HomeFeed
import fragments.ActorsRecyclerViewFragment
import fragments.MovieDescriptionFragment

class SelectionsPagerAdapter(fm: FragmentManager, homeFeed: HomeFeed,
                             selectedMovieIndex: Int) : FragmentPagerAdapter(fm) {

    val homeFeed = homeFeed
    val selectedMovieIndex = selectedMovieIndex
    override fun getItem(position: Int): Fragment {
        val bundle = Bundle()
        when (position) {
            0 -> {
                val actorsRecyclerViewFragment = ActorsRecyclerViewFragment()
                bundle.putSerializable(Consts.HOME_FEED, homeFeed)
                bundle.putInt(Consts.SELECTED_MOVIE_INDEX, selectedMovieIndex)
                actorsRecyclerViewFragment.arguments = bundle
                return actorsRecyclerViewFragment
            }
            1 -> {
                val movieDescriptionFragment = MovieDescriptionFragment()
                bundle.putString(Consts.DESCRIPTION, homeFeed.movies[selectedMovieIndex].description)
                movieDescriptionFragment.arguments = bundle
                return movieDescriptionFragment
            }
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return 2
    }
}
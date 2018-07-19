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
import fragments.MovieImagesFragment

class SelectionsPagerAdapter(fm: FragmentManager, private val homeFeed: HomeFeed,
                             private val selectedMovieIndex: Int, private val numberOfTabs: Int) : FragmentPagerAdapter(fm) {

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

            2 -> {
                val movieImagesFragment = MovieImagesFragment()
                bundle.putInt(Consts.SELECTED_MOVIE_INDEX, selectedMovieIndex)
                movieImagesFragment.arguments = bundle
                return movieImagesFragment
            }
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return numberOfTabs
    }
}
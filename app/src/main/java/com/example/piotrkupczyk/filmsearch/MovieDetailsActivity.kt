package com.example.piotrkupczyk.filmsearch

import adapters.SelectionsPagerAdapter
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.squareup.picasso.Picasso
import dataClasses.HomeFeed
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    var selectedMovieIndex: Int = 0
    lateinit var homeFeed: HomeFeed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        initIntent()
        initView()
        initViewPager()
    }

    private fun initIntent() {
        val bundle = intent.extras
        homeFeed = bundle.getSerializable(HOME_FEED) as HomeFeed
        selectedMovieIndex = bundle.getInt(SELECTED_MOVIE_INDEX)
    }

    private fun setBackground(movieCategory: String) {
        when (movieCategory) {
            "Drama" -> {
                detailsLayout.setBackgroundColor(ContextCompat
                        .getColor(this, R.color.dramaBackground))
            }
            "Crime" -> {
                detailsLayout.setBackgroundColor(ContextCompat
                        .getColor(this, R.color.crimeBackground))
            }
            "Action" -> {
                detailsLayout.setBackgroundColor(ContextCompat
                        .getColor(this, R.color.actionBackground))
            }
            "Adventure" -> {
                detailsLayout.setBackgroundColor(ContextCompat
                        .getColor(this, R.color.adventureBackground))
            }
            "Fantasy" -> {
                detailsLayout.setBackgroundColor(ContextCompat
                        .getColor(this, R.color.fantasyBackground))
            }
        }
    }


    private fun initView() {
        val movie = homeFeed.movies[selectedMovieIndex]

        //load image via Picasso
        Picasso.with(this)
                .load(movie.posterUrl)
                .into(detailsMoviePoster)

        detailsMovieName.text = movie.title
        detailsMovieCategories.text = movie.genresToString()
        //default we take first genre. More advanced parsing will be implemented soon
        setBackground(homeFeed.movies[selectedMovieIndex].genres[0])
    }

    private fun initViewPager() {
        val numberOfTabs = 3
        detailsViewPager.adapter = SelectionsPagerAdapter(supportFragmentManager,
                                                    homeFeed, selectedMovieIndex,
                                                    numberOfTabs)
        tabLayout.setupWithViewPager(detailsViewPager)
    }

    companion object {
        fun start(context: Context, selectedMovieIndex: Int, homeFeed: HomeFeed) {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(HOME_FEED, homeFeed)
            intent.putExtra(SELECTED_MOVIE_INDEX, selectedMovieIndex)
            context.startActivity(intent)
        }
        private const val HOME_FEED = "HOME_FEED"
        private const val SELECTED_MOVIE_INDEX = "SELECTED_MOVIE_INDEX"
    }
}

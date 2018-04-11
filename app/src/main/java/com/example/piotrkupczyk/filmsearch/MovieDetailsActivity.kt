package com.example.piotrkupczyk.filmsearch

import adapters.ActorAdapter
import adapters.SelectionsPagerAdapter
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import dataClasses.HomeFeed
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.actors.*
import kotlinx.android.synthetic.main.move_description_fragment.*
import kotlinx.android.synthetic.main.movie_row.*

class MovieDetailsActivity : AppCompatActivity() {

    var selectedMovieIndex: Int = 0
    lateinit var homeFeed: HomeFeed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        initIntent()
        initView()
        initFragments()
    }

    fun initIntent() {
        val bundle = intent.extras
        homeFeed = bundle.getSerializable(HOME_FEED) as HomeFeed
        selectedMovieIndex = bundle.getInt(SELECTED_MOVIE_INDEX)
    }

    fun initView() {
        val movie = homeFeed.movies[selectedMovieIndex]

        //load image via Picasso
        Picasso.with(this)
                .load(movie.posterUrl)
                .into(detailsMoviePoster)

        detailsMovieName.text = movie.title
        detailsMovieCategories.text = movie.genres.toString()
    }

    fun initFragments() {
        viewPager.adapter = SelectionsPagerAdapter(supportFragmentManager,
                                                    homeFeed, selectedMovieIndex)
        tabLayout.setupWithViewPager(viewPager)
    }

    companion object {
        fun start(context: Context, selectedMovieIndex: Int, homeFeed: HomeFeed) {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(HOME_FEED, homeFeed)
            intent.putExtra(SELECTED_MOVIE_INDEX, selectedMovieIndex)
            context.startActivity(intent)
        }
        private val HOME_FEED = "HOME_FEED"
        private val SELECTED_MOVIE_INDEX = "SELECTED_MOVIE_INDEX"
    }
}

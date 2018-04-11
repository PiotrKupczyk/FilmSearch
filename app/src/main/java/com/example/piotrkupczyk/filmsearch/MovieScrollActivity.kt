package com.example.piotrkupczyk.filmsearch

import adapters.MovieAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import com.beust.klaxon.Klaxon
import dataClasses.HomeFeed
import itemTouchHelpers.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.activity_film_scroll.*
import okhttp3.*
import java.io.*

class MovieScrollActivity : AppCompatActivity() {

    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_scroll)

        initRecyclerView()
        fetchJSON()
//        initSwipeToDelete()
    }

    fun initRecyclerView() {
        recyclerView_main.layoutManager = LinearLayoutManager(this)
    }

    fun fetchJSON() {
        val jsonURL = "https://raw.githubusercontent.com/PiotrKupczyk/sorting/master/movies_and_actors"

        val request = Request.Builder().url(jsonURL).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call?, e: IOException?) {
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val result = Klaxon().parse<HomeFeed>(body!!)

                runOnUiThread {
                    adapter = MovieAdapter(result!!, this@MovieScrollActivity)
                    recyclerView_main.adapter = adapter
                    initSwipeToDelete()
                }
            }

        })
    }

    fun initSwipeToDelete() {
        val callback = SwipeToDeleteCallback(adapter)
        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(recyclerView_main)
    }


}


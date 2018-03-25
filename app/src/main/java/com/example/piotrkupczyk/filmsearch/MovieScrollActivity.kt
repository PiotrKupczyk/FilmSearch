package com.example.piotrkupczyk.filmsearch

import adapters.MovieAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.beust.klaxon.Klaxon
import dataClasses.HomeFeed
import kotlinx.android.synthetic.main.activity_film_scroll.*
import okhttp3.*
import java.io.*

class MovieScrollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_scroll)

        initRecyclerView()
        fetchJSON()

    }

    fun initRecyclerView() {
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = MovieAdapter(arrayListOf())
    }

    fun fetchJSON() {
        val jsonURL = "https://gist.githubusercontent.com/Yuriy1988/2f1246940e0e6bad49b3c17cac4d69b4/raw/732231a6d626788433ddeef1f828272e808b0a96/movies_actors"

        val request = Request.Builder().url(jsonURL).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call?, e: IOException?) {

            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val result = Klaxon().parse<HomeFeed>(body!!)
            }

        })

//        val bufferReader = BufferedReader(InputStreamReader(assets.open("moviesData")))
//        val inputString = bufferReader.use { it.readText() }
//
//        val result = Klaxon().parse<List<Movie>>(inputString)
//        print(result)

    }
}


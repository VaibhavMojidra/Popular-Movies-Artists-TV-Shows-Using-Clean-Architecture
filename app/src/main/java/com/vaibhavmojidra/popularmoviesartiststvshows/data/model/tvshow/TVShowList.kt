package com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val tvShows: List<TVShow>,
)
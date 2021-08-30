package com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TVShow>?=tvShowRepository.getTvShows()
}
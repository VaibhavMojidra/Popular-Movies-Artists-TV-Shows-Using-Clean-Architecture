package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.GetTvShowUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(private val getTvShowUseCase: GetTvShowUseCase,private val updateTvShowUseCase: UpdateTvShowUseCase):ViewModel() {
    fun getTvShows()= liveData {
        val tvShowList=getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows()= liveData {
        val tvShowList=updateTvShowUseCase.execute()
        emit(tvShowList)
    }
}
package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.GetTvShowUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(private val getTvShowUseCase: GetTvShowUseCase, private val updateTvShowUseCase: UpdateTvShowUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =TvShowViewModel(getTvShowUseCase,updateTvShowUseCase) as T

}
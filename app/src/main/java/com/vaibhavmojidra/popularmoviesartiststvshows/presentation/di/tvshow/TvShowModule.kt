package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.tvshow

import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.GetTvShowUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateTvShowUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowUseCase: GetTvShowUseCase,updateTvShowUseCase: UpdateTvShowUseCase):TvShowViewModelFactory=
        TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
}
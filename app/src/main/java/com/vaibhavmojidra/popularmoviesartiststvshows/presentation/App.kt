package com.vaibhavmojidra.popularmoviesartiststvshows.presentation

import android.app.Application
import com.vaibhavmojidra.popularmoviesartiststvshows.BuildConfig
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.Injector
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.artist.ArtistSubComponent
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.core.*
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.movie.MovieSubComponent
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.tvshow.TvShowSubComponent


class App:Application(),Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent =appComponent.movieSubComponent().create()

    override fun createArtistSubComponent(): ArtistSubComponent=appComponent.artistSubComponent().create()

    override fun createTvShowSubComponent(): TvShowSubComponent=appComponent.tvShowSubComponent().create()
}
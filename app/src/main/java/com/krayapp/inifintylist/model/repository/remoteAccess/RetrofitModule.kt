package com.krayapp.inifintylist.model.repository.remoteAccess

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {
    private const val baseUrl = "https://www.reddit.com/"
    fun getApi():RedditPostSource =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()
            .create(RedditPostSource::class.java)
}
package com.krayapp.inifintylist.model.repository.remoteAccess

import androidx.annotation.IntRange
import com.krayapp.inifintylist.model.RedditRequestDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditPostSource {
    @GET("r/aww/hot.json")
    suspend fun getPosts(
        @Query("page") @IntRange(from = 1) page: Int = 1,
        @Query("pageSize") @IntRange(from = 1, to = MAX_PAGE_SIZE.toLong()) pageSize: Int = DEFAULT_PAGE_SIZE
    ):Response<RedditRequestDTO>

    companion object {
        const val DEFAULT_PAGE_SIZE = 10
        const val MAX_PAGE_SIZE = 10
    }
}
package com.krayapp.inifintylist.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.krayapp.inifintylist.model.repository.remoteAccess.RedditPostSource
import retrofit2.HttpException

class RedditPagingSource(
    private val apiSource: RedditPostSource
) : PagingSource<Int, RedditPost>() {
    companion object {
        const val INITIAL_PAGE_NUMBER = 1
    }

    override fun getRefreshKey(state: PagingState<Int, RedditPost>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RedditPost> {
        return try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val pageSize = params.loadSize.coerceAtMost(RedditPostSource.MAX_PAGE_SIZE)
            val response = apiSource.getPosts(page = pageNumber, pageSize = pageSize)
            if (response.isSuccessful) {
                val hotPost = response.body()!!.data.children.map { it.data.toPost() }
                val nextPageNumber = if (hotPost.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                LoadResult.Page(hotPost, prevPageNumber, nextPageNumber)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}
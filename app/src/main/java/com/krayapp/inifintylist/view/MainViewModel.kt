package com.krayapp.inifintylist.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.krayapp.inifintylist.model.RedditPagingSource
import com.krayapp.inifintylist.model.RedditPost
import kotlinx.coroutines.flow.*

class MainViewModel(private val pagingSource: RedditPagingSource) : ViewModel() {

    val hotPost: StateFlow<PagingData<RedditPost>> =
        Pager(config = PagingConfig(5, enablePlaceholders = false),
            pagingSourceFactory = { pagingSource }
        ).flow
            .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())


}


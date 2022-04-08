package com.krayapp.inifintylist.model.repository

import androidx.paging.PagingSource
import com.krayapp.inifintylist.model.RedditPost
import com.krayapp.inifintylist.model.repository.remoteAccess.RedditPostSource

class MainRepo(
    private val api:RedditPostSource
)

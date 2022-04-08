package com.krayapp.inifintylist

import com.krayapp.inifintylist.model.PostDTO
import com.krayapp.inifintylist.model.RedditPost

fun PostDTO.toPost(): RedditPost {
    return RedditPost(
        id = 0, author = author,
        award_count = award_count,
        description = description,
        comment_count = comment_count
    )
}

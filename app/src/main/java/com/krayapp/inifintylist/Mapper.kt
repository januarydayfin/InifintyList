package com.krayapp.inifintylist

import com.krayapp.inifintylist.model.ChildrenDataDTO
import com.krayapp.inifintylist.model.PostDTO
import com.krayapp.inifintylist.model.RedditPost

fun ChildrenDataDTO.toPost(): RedditPost {
    return RedditPost(
        id = 0, author = data.author,
        award_count = data.award_count,
        description = data.description,
        comment_count = data.comment_count
    )
}

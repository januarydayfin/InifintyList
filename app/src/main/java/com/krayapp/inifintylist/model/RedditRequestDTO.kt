package com.krayapp.inifintylist.model

import com.google.gson.annotations.SerializedName

data class RedditRequestDTO(
    @SerializedName("data") val data: ChildrenDTO
)

data class ChildrenDTO(
    @SerializedName("children") val children: List<ChildrenDataDTO>
)

fun PostDTO.toPost(): RedditPost {
    return RedditPost(
        id = 0, author = author,
        award_count = award_count,
        description = description,
        comment_count = comment_count
    )
}

data class ChildrenDataDTO(
    @SerializedName("data") val data: PostDTO
)

data class PostDTO(
    val id: Int?,
    @SerializedName("author_fullname") val author: String,
    @SerializedName("description") val description: String,
    @SerializedName("total_awards_received") val award_count: Int,
    @SerializedName("ups") val comment_count: Int
)

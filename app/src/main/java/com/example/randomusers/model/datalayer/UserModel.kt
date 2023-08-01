package com.example.randomusers.model.datalayer

import com.google.gson.annotations.SerializedName

/**
 * Data class represents [UserModel] object.
 *
 * @author: tonghann.teng
 * @since: 7/24/23
 */
data class UserModel(
    @SerializedName("results")
    val result: List<UserResult>? = null,
    @SerializedName("info")
    val info: Info? = null
)

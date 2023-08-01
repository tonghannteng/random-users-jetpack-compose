package com.example.randomusers.model.datalayer

import com.google.gson.annotations.SerializedName

/**
 * Data class represents [UserResult] object.
 *
 * @author: tonghann.teng
 * @since: 7/24/23
 */
data class UserResult(
    @SerializedName("name")
    val name: Name? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("picture")
    val picture: Picture? = null
)

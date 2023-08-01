package com.example.randomusers.model.datalayer

/**
 * Data class represents [Location] object.
 *
 * @author: tonghann.teng
 * @since: 7/24/23
 */
data class Location(
    val street: Street? = null,
    val city: String? = null,
    val state: String? = null,
    val country: String? = null,
    val postcode: String? = null
)

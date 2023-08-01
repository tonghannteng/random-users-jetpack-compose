package com.example.randomusers.model.datalayer

/**
 * Data class represents [Info] object.
 *
 * @author: tonghann.teng
 * @since: 7/24/23
 */
data class Info (
    val seed: String? = null,
    val results: Int? = 0,
    val page: Int? = 0,
    val version: String? = null
)

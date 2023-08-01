package com.example.randomusers.repository

import com.example.randomusers.api.ApiService
import javax.inject.Inject

/**
 * Represents repository [UserResultRepository].
 *
 * @author: tonghann.teng
 * @since: 7/24/23
 */
class UserResultRepository @Inject constructor(private val apiService: ApiService) {

    /**
     * Get all Results from [ApiService].
     */
    suspend fun getAllResults() = apiService.getAllResults()
}

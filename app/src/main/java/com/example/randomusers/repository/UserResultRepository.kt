package com.example.randomusers.repository

import com.example.randomusers.api.ApiService
import com.example.randomusers.common.UiDataState
import com.example.randomusers.model.datalayer.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
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

    fun getAllResultsFlow() : Flow<UserModel> {
        return flow {
            emit(apiService.getAllResults())
        }.map {
            it
        }
    }
}

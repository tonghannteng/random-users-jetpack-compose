package com.example.randomusers.api

import com.example.randomusers.model.datalayer.UserModel
import com.example.randomusers.utils.Constants
import retrofit2.http.GET

/**
 * @author: tonghann.teng
 * @since: 7/24/23
 */
interface ApiService {

    @GET(Constants.BASE_URL)
    suspend fun getAllResults(): UserModel
}

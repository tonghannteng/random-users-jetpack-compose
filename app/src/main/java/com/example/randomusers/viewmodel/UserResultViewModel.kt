package com.example.randomusers.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomusers.model.datalayer.UserModel
import com.example.randomusers.model.presentationlayer.UserInfo
import com.example.randomusers.repository.UserResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author: tonghann.teng
 * @since: 7/25/23
 */
@HiltViewModel
class UserResultViewModel @Inject constructor(private val repository: UserResultRepository) :
    ViewModel() {

    companion object {
        private const val TAG = "UserResultViewModel"
    }

    private val _userResult = MutableStateFlow<UserModel?>(null)
    val userResult = _userResult.asStateFlow()

    private val _userDetails = MutableStateFlow<UserInfo?>(null)
    val userDetails = _userDetails.asStateFlow()

    /**
     * Get all users result.
     */
    fun getAllResults() = viewModelScope.launch {
        val result = repository.getAllResults()
        _userResult.value = result
        Log.d(TAG, result.toString())
    }

    /**
     * Get User details.
     */
    fun setUserDetails(userInfo: UserInfo) {
        _userDetails.value = userInfo
    }
}

package com.example.randomusers.model.presentationlayer

import com.example.randomusers.model.datalayer.UserModel
import com.example.randomusers.utils.getUserName

/**
 * Data class represents presentation layer for [UserModel].
 *
 * @author: tonghann.teng
 * @since: 7/24/23
 */
data class UserInfo(
    val picture: String,
    val fullName: String,
    val email: String,
    val phone: String
) {
    companion object {
        fun mapUserModelToUserInfo(userModel: UserModel?): List<UserInfo> {
            if (userModel == null) return emptyList()
            if (userModel.result.isNullOrEmpty()) return emptyList()
            val userInfo = userModel.result.map {
                val picture = it.picture?.large ?: ""
                val fullName = it.name?.getUserName() ?: ""
                val email = it.email ?: ""
                val phone = it.phone ?: ""
                UserInfo(
                    picture = picture,
                    fullName = fullName,
                    email = email,
                    phone = phone
                )
            }
            return userInfo
        }
    }
}

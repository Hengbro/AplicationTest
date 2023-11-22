package com.hengki.aplicationtest.core.repo

import com.hengki.aplicationtest.core.source.local.LocalDataSource
import com.hengki.aplicationtest.core.source.model.User
import com.hengki.aplicationtest.core.source.remote.network.ApiService
import com.hengki.aplicationtest.core.source.remote.network.ResponseHandler
import com.hengki.aplicationtest.core.source.remote.request.LoginRequest
import com.hengki.aplicationtest.core.source.remote.request.RegisterRequest
import com.hengki.aplicationtest.core.source.remote.response.base.DataResponse
import com.hengki.aplicationtest.util.Prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class AuthRepository(val local: LocalDataSource, val remote: ApiService) {

    fun login(mData: LoginRequest) = object : ResponseHandler<User, DataResponse<User>>() {
        override suspend fun createCall(): Response<DataResponse<User>> {
            return remote.login(mData)
        }

        override suspend fun resultCall(data: DataResponse<User>): User {
            val user = data.data ?: User()
            Prefs.isLogin = true
            Prefs.token = user.token
            return user
        }
    }.asFlow().flowOn(Dispatchers.IO)

    fun register(mData: RegisterRequest) = object : ResponseHandler<User, DataResponse<User>>() {
        override suspend fun createCall(): Response<DataResponse<User>> {
            return remote.register(mData)
        }

        override suspend fun resultCall(data: DataResponse<User>): User {
            val user = data.data ?: User()
            Prefs.token = user.token ?: "token"
            return user
        }
    }.asFlow().flowOn(Dispatchers.IO)
}
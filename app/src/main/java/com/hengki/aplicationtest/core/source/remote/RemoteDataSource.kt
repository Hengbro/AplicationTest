package com.hengki.aplicationtest.core.source.remote

import com.hengki.aplicationtest.core.source.remote.network.ApiService
import com.hengki.aplicationtest.core.source.remote.request.LoginRequest
import com.hengki.aplicationtest.core.source.remote.request.RegisterRequest

class RemoteDataSource(private val api: ApiService) {
    suspend fun login(user: LoginRequest) = api.login(user)
    suspend fun register(user: RegisterRequest) = api.register(user)

}
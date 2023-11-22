package com.hengki.aplicationtest.core.source.remote.network

import com.hengki.aplicationtest.core.source.local.entity.ProductEntity
import com.hengki.aplicationtest.core.source.model.User
import com.hengki.aplicationtest.core.source.remote.request.LoginRequest
import com.hengki.aplicationtest.core.source.remote.request.ProductRequest
import com.hengki.aplicationtest.core.source.remote.request.RegisterRequest
import com.hengki.aplicationtest.core.source.remote.response.base.DataResponse
import com.hengki.aplicationtest.core.source.remote.response.base.ListResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("auth/login")
    suspend fun login(
        @Body user: LoginRequest
    ): Response<DataResponse<User>>

    @POST("auth/register")
    suspend fun register(
        @Body user: RegisterRequest
    ): Response<DataResponse<User>>


    @GET("category")
    suspend fun getCategory(): Response<ListResponse<ProductEntity>>

    @POST("category")
    suspend fun createCategory(
        @Body data: ProductRequest
    ): Response<DataResponse<ProductEntity>>

    @PUT("category/{id}")
    suspend fun updateCategory(
        @Path("id") id: Int?,
        @Body data: ProductRequest
    ): Response<DataResponse<ProductEntity>>

    @DELETE("category/{id}")
    suspend fun deleteCategory(
        @Path("id") id: Int?
    ): Response<DataResponse<ProductEntity>>

}
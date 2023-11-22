package com.hengki.aplicationtest.ui.auth

import androidx.lifecycle.*
import com.hengki.aplicationtest.core.repo.AuthRepository
import com.hengki.aplicationtest.core.source.remote.request.LoginRequest
import com.hengki.aplicationtest.core.source.remote.request.RegisterRequest

class AuthViewModel(private val repository: AuthRepository) : ViewModel()  {

    fun login(data: LoginRequest) = repository.login(data).asLiveData()
    fun register(data: RegisterRequest) = repository.register(data).asLiveData()

}
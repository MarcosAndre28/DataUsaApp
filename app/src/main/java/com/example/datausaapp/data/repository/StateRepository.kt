package com.example.datausaapp.data.repository

import com.example.datausaapp.data.api.ApiData
import com.example.datausaapp.data.model.State
// Repositorio onde implementamos a regra de negócio no porcessamento de informações
class StateRepository(private val getInstance: ApiData?) {

    suspend fun getStates(): List<State> {
        val response = getInstance?.getStates()?.data ?: listOf()
        return response
    }
}
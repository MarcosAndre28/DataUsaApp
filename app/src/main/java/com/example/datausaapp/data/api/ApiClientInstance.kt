package com.example.datausaapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// Retrofit
object ApiClientInstance {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://datausa.io/api/"

    // Criação da instancia do Retrofit
    val retrofitInstance: ApiData?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(ApiData::class.java)
        }
}
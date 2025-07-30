package com.example.project7.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApiService {
    @GET("planetary/apod")
    suspend fun getApodList(
        @Query("api_key") apiKey: String,
        @Query("count") count: Int = 10 // Fetch 10 random images
    ): List<NasaPhoto>
}



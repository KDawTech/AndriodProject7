package com.example.project7.data.remote.dto

import com.example.project7.data.Apod

data class ApodDto(
    val title: String,
    val date: String,
    val url: String,
    val media_type: String
)

fun ApodDto.toDomain(): Apod = Apod(title, date, url)
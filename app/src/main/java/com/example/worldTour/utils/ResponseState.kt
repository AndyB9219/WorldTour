package com.example.worldTour.utils

import com.example.worldTour.model.CountriesDetails

sealed interface ResponseState {
    object LOADING: ResponseState
    class SUCCESS(val countries: List<CountriesDetails>): ResponseState
    class ERROR(val error: Throwable): ResponseState
}
package com.example.worldTour.rest

import com.example.worldTour.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

interface CountriesRepository {
    fun getAllCountries(): Flow<ResponseState>
}

class CountriesRepositoryImp @Inject constructor(
    private val apiService: APIService
): CountriesRepository{

    override fun getAllCountries(): Flow<ResponseState> =
        flow {
            emit(ResponseState.LOADING)
            try{
                val response = apiService.getAllCountries()
                if(response.isSuccessful){
                    response.body()?.let {
                        emit(ResponseState.SUCCESS(it))
                    }?: throw Exception("Response null")
                }else throw Exception("No response")
            }catch (e: Exception){
                emit(ResponseState.ERROR(e))
            }
        }
}
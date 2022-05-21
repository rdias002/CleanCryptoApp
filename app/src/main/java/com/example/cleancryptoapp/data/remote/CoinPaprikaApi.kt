package com.example.cleancryptoapp.data.remote

import com.example.cleancryptoapp.data.remote.dto.CoinDetailsDto
import com.example.cleancryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getAllCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path(value = "coinId") coinId: String): CoinDetailsDto


}
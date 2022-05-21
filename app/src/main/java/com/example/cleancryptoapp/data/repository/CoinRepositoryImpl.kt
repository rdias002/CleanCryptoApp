package com.example.cleancryptoapp.data.repository

import com.example.cleancryptoapp.data.remote.CoinPaprikaApi
import com.example.cleancryptoapp.data.remote.dto.CoinDetailsDto
import com.example.cleancryptoapp.data.remote.dto.CoinDto
import com.example.cleancryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = coinPaprikaApi.getAllCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailsDto = coinPaprikaApi.getCoinById(coinId)
}
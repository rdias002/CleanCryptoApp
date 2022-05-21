package com.example.cleancryptoapp.domain.repository

import com.example.cleancryptoapp.data.remote.dto.CoinDetailsDto
import com.example.cleancryptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailsDto
}
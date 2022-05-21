package com.example.cleancryptoapp.presentation.coin_detail

import com.example.cleancryptoapp.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)

package com.example.cleancryptoapp.presentation.coin_list

import com.example.cleancryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

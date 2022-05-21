package com.example.cleancryptoapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleancryptoapp.common.Constants
import com.example.cleancryptoapp.common.Resource
import com.example.cleancryptoapp.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let{
            getCoinDetails(it)
        }
    }

    private fun getCoinDetails(coinId: String){
        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coin = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailsState(error = result.message ?: "Something went wrong")
                }
            }
        }.launchIn(viewModelScope)
    }
}
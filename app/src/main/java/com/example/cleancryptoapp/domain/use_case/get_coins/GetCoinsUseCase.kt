package com.example.cleancryptoapp.domain.use_case.get_coins

import com.example.cleancryptoapp.common.Resource
import com.example.cleancryptoapp.domain.model.Coin
import com.example.cleancryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success<List<Coin>>(coins.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage?:"Some error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Could not reach server"))
        }
    }
}
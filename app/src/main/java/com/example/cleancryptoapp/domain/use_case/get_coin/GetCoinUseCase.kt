package com.example.cleancryptoapp.domain.use_case.get_coin

import com.example.cleancryptoapp.common.Resource
import com.example.cleancryptoapp.domain.model.CoinDetails
import com.example.cleancryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())
            val coinDetails = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetails>(coinDetails.toCoinDetails() ))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetails>(e.localizedMessage?:"Some error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetails>("Could not reach server"))
        }
    }
}
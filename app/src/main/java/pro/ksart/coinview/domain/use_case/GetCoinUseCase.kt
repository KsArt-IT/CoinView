package pro.ksart.coinview.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.ksart.coinview.domain.entities.Results
import pro.ksart.coinview.data.remote.dto.toCoinDetail
import pro.ksart.coinview.domain.entities.CoinDetail
import pro.ksart.coinview.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Results<CoinDetail>> = flow {
        try {
            emit(Results.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Results.Success(coin))
        } catch(e: HttpException) {
            emit(Results.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Results.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}

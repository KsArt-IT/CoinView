package pro.ksart.coinview.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.ksart.coinview.domain.entities.Results
import pro.ksart.coinview.data.remote.dto.toCoin
import pro.ksart.coinview.domain.entities.Coin
import pro.ksart.coinview.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Results<List<Coin>>> = flow {
        try {
            emit(Results.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Results.Success(coins))
        } catch (e: HttpException) {
            emit(Results.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Results.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}

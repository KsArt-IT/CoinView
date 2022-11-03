package pro.ksart.coinview.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import pro.ksart.coinview.data.remote.CoinPaprikaApiService
import pro.ksart.coinview.data.remote.dto.CoinDetailDto
import pro.ksart.coinview.data.remote.dto.CoinDto
import pro.ksart.coinview.di.IoDispatcher
import pro.ksart.coinview.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val service: CoinPaprikaApiService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = withContext(dispatcher) {
        service.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto = withContext(dispatcher) {
        service.getCoinById(coinId)
    }
}

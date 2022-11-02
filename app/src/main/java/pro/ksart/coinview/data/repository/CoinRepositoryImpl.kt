package pro.ksart.coinview.data.repository

import pro.ksart.coinview.data.remote.CoinPaprikaApiService
import pro.ksart.coinview.data.remote.dto.CoinDetailDto
import pro.ksart.coinview.data.remote.dto.CoinDto
import pro.ksart.coinview.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val service: CoinPaprikaApiService
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = service.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDto = service.getCoinById(coinId)
}

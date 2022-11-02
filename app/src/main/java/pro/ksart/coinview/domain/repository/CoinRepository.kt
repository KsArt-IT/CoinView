package pro.ksart.coinview.domain.repository

import pro.ksart.coinview.data.remote.dto.CoinDetailDto
import pro.ksart.coinview.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}

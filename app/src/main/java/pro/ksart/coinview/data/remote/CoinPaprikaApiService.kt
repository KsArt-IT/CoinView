package pro.ksart.coinview.data.remote

import pro.ksart.coinview.data.remote.dto.CoinDetailDto
import pro.ksart.coinview.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{$PARAM_COIN_ID}")
    suspend fun getCoinById(
        @Path(PARAM_COIN_ID) coinId: String
    ): CoinDetailDto

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com/"

        const val PARAM_COIN_ID = "coinId"
    }
}

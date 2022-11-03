package pro.ksart.coinview.presentation.coin_list

import pro.ksart.coinview.domain.entities.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

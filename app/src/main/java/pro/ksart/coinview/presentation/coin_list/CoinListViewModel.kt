package pro.ksart.coinview.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.ksart.coinview.domain.entities.Results
import pro.ksart.coinview.domain.use_case.GetCoinsUseCase
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Results.Success -> {
                    _state.value = CoinListState(coins = result.data)
                }

                is Results.Error -> {
                    _state.value = CoinListState(error = result.message)
                }

                is Results.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}

package pro.ksart.coinview.domain.entities

sealed class Results<out T : Any> {

    data class Success<out T : Any>(val data: T) : Results<T>()

    data class Error(val message: String) : Results<Nothing>()

    data class Loading<out T : Any>(val data: T? = null) : Results<T>()

}

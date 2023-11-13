package br.com.popularjavareposapp.ui.viewmodel.result

import java.lang.Exception


sealed class ResultViewState<out R> {
    object Loading : ResultViewState<Nothing>()
    data class Success<out T>(val data: T) : ResultViewState<T>()
    data class Error(val exception: Exception) : ResultViewState<Nothing>()
    object Initial : ResultViewState<Nothing>()
}

package br.com.popularjavareposapp.ui.viewmodel.result.mapper

import br.com.popularjavareposapp.network.result.ResponseResult
import br.com.popularjavareposapp.ui.viewmodel.result.ResultViewState

object ResultMapper {
    fun <T> toResultViewState(responseResult: ResponseResult<T>): ResultViewState<T> {
        return when (responseResult) {
            is ResponseResult.Success -> ResultViewState.Success(responseResult.data)
            is ResponseResult.Error -> ResultViewState.Error(responseResult.exception)
        }
    }
}

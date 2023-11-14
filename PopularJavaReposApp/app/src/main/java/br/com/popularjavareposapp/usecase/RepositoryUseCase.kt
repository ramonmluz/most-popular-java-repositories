package br.com.popularjavareposapp.usecase

import br.com.popularjavareposapp.data.Repository
import br.com.popularjavareposapp.model.RepositoryModel
import br.com.popularjavareposapp.model.toRepositories
import br.com.popularjavareposapp.network.result.ResponseResult
import br.com.popularjavareposapp.ui.viewmodel.result.ResultViewState

class RepositoryUseCase(private val repository: Repository) {
    suspend fun loadPopularJavaRepositories(): ResultViewState<List<RepositoryModel>> {
        return when (val responseResult = repository.loadPopularJavaRepositories(PAGE_NUMBER)) {
            is ResponseResult.Success -> ResultViewState.Success(responseResult.data.toRepositories())
            is ResponseResult.Error -> ResultViewState.Error(responseResult.exception)
        }
    }

    companion object {
        const val PAGE_NUMBER = "1"
    }
}
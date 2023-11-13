package br.com.popularjavareposapp.usecase

import br.com.popularjavareposapp.data.Repository
import br.com.popularjavareposapp.ui.viewmodel.result.ResultViewState
import br.com.popularjavareposapp.ui.viewmodel.result.mapper.ResultMapper

class RepositoryUseCase (private val repository: Repository) {

    suspend fun loadPopularJavaRepositories() : ResultViewState<br.com.popularjavareposapp.model.Repository> {
       return ResultMapper.toResultViewState(repository.loadPopularJavaRepositories(PAGE_NUMBER))
    }

    companion object{
        const val  PAGE_NUMBER= "1"
    }
}
package br.com.popularjavareposapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.popularjavareposapp.model.RepositoryModel
import br.com.popularjavareposapp.ui.viewmodel.result.ResultViewState
import br.com.popularjavareposapp.usecase.RepositoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RepositoryViewModel(private val repositoryUseCase: RepositoryUseCase) : ViewModel() {

    private val _repositories = MutableStateFlow<ResultViewState<List<RepositoryModel>>>(
        ResultViewState.Initial
    )

    val repositories = _repositories.asStateFlow()

    fun loadPopularJavaRepositories() {
        _repositories.tryEmit(ResultViewState.Loading)
        viewModelScope.launch {
            val result = repositoryUseCase.loadPopularJavaRepositories()
            _repositories.tryEmit(result)
        }
    }
}
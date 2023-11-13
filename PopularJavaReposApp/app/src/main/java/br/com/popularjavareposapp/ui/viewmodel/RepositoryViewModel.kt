package br.com.popularjavareposapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.popularjavareposapp.data.Repository
import kotlinx.coroutines.launch

class RepositoryViewModel (private val repository: Repository): ViewModel(){

    fun loadPopularJavaRepositories() {
        viewModelScope.launch {
            val result = repository.loadPopularJavaRepositories("1")
        }
    }
}
package br.com.popularjavareposapp.data

import br.com.popularjavareposapp.model.RepositoryModel
import br.com.popularjavareposapp.model.RepositoryResponse
import br.com.popularjavareposapp.network.result.ResponseResult

interface Repository {
    suspend fun loadPopularJavaRepositories(pageNumber: String): ResponseResult<RepositoryResponse>
}
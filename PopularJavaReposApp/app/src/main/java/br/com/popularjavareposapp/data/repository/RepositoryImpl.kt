package br.com.popularjavareposapp.data.repository

import br.com.popularjavareposapp.data.Repository
import br.com.popularjavareposapp.model.RepositoryModel
import br.com.popularjavareposapp.model.RepositoryResponse
import br.com.popularjavareposapp.network.api.RepositoryServiceApi
import br.com.popularjavareposapp.network.result.ResponseResult

class RepositoryImpl(private val repositoryServiceApi: RepositoryServiceApi) : Repository {
    override suspend fun loadPopularJavaRepositories(
        pageNumber: String,
    ): ResponseResult<RepositoryResponse> {
        val params = mapOf(
            Pair("q", "language:Java"), Pair("sort", "stars"), Pair("page", pageNumber)
        )
        return try {
            val repositoryResponse = repositoryServiceApi.loadPopularJavaRepositories(params)
            ResponseResult.Success(repositoryResponse)
        } catch (exception: Exception) {
            ResponseResult.Error(exception)
        }
    }
}
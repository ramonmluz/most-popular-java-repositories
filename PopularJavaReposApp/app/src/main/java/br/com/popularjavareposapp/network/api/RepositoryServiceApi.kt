package br.com.popularjavareposapp.network.api

import br.com.popularjavareposapp.model.RepositoryResponse
import br.com.popularjavareposapp.network.result.ResponseResult
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface RepositoryServiceApi {
    @GET("search/repositories")
    suspend fun loadPopularJavaRepositories(@QueryMap (encoded = true) prams: Map<String, String>): RepositoryResponse
}


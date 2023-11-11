package br.com.popularjavareposapp.network.api

import br.com.popularjavareposapp.model.Repository
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface RepositoryServiceApi {
    @GET("search/repositories")
    suspend fun loadPopularJavaRepositories(@QueryMap prams: Map<String, String>): Repository
}


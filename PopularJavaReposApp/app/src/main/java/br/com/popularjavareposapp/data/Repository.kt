package br.com.popularjavareposapp.data

import br.com.popularjavareposapp.model.Repository
import br.com.popularjavareposapp.network.result.ResponseResult

interface Repository {
    suspend fun loadPopularJavaRepositories(pageNumber: String):  ResponseResult<Repository>
}
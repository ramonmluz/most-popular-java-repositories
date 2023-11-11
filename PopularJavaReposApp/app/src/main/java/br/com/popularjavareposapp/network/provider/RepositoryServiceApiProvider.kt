package br.com.popularjavareposapp.network.provider

import br.com.popularjavareposapp.network.api.RepositoryServiceApi
import retrofit2.Retrofit

object RepositoryServiceApiProvider {
    fun provideRepositoryServiceApi(retrofit: Retrofit): RepositoryServiceApi =
        retrofit.create(RepositoryServiceApi::class.java)
}
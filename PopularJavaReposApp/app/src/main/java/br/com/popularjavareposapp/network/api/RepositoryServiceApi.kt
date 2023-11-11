package br.com.popularjavareposapp.network.api

import retrofit2.http.GET


interface RepositoryServiceApi {
   @GET("breeds/list/all")
    suspend fun loadDogsBreedsAll(): DogBreedsResponse
}


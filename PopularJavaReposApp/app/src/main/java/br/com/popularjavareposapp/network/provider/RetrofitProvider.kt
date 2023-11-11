package br.com.popularjavareposapp.network.provider

import br.com.popularjavareposapp.BuildConfig
import br.com.popularjavareposapp.network.okhttp.interceptor.OkhttpFactory
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {
    fun provideRetrofit(okhttpFactory: OkhttpFactory): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        val client = okhttpFactory.getClientRetrofit()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}

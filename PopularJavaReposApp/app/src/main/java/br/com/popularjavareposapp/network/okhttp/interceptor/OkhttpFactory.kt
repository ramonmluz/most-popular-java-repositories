package br.com.popularjavareposapp.network.okhttp.interceptor

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkhttpFactory(
    private val httpLoggingInterceptor: HttpLoggingInterceptor,
    private val authenticationInterceptor: AuthenticationInterceptor,
) {
    fun getClientRetrofit(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authenticationInterceptor)
            .build()
    }
}
package br.com.popularjavareposapp.network.provider

import okhttp3.logging.HttpLoggingInterceptor

object HttpInterceptorProvider {

    fun provideHttpInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}
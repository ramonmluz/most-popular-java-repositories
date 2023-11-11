package br.com.popularjavareposapp.di

import br.com.popularjavareposapp.network.okhttp.interceptor.AuthenticationInterceptor
import br.com.popularjavareposapp.network.okhttp.interceptor.OkhttpFactory
import br.com.popularjavareposapp.network.provider.HttpInterceptorProvider.provideHttpInterceptor
import br.com.popularjavareposapp.network.provider.RepositoryServiceApiProvider.provideRepositoryServiceApi
import br.com.popularjavareposapp.network.provider.RetrofitProvider.provideRetrofit
import org.koin.dsl.module

object NetworkModule {
    val netWorkModule = module {
        factory { provideHttpInterceptor() }
        factory { AuthenticationInterceptor() }
        factory { OkhttpFactory(get(), get()) }
        single { provideRetrofit(get()) }
        factory { provideRepositoryServiceApi(get()) }
    }
}
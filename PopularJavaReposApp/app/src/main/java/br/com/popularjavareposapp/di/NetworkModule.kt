package br.com.popularjavareposapp.di

import br.com.popularjavareposapp.BuildConfig
import br.com.popularjavareposapp.network.api.RepositoryServiceApi
import br.com.popularjavareposapp.network.okhttp.interceptor.AuthenticationInterceptor
import br.com.popularjavareposapp.network.okhttp.interceptor.OkhttpFactory
import br.com.popularjavareposapp.network.provider.HttpInterceptorProvider.provideHttpInterceptor
import br.com.popularjavareposapp.network.provider.RepositoryServiceApiProvider.provideRepositoryServiceApi
import br.com.popularjavareposapp.network.provider.RetrofitProvider.provideRetrofit
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    val netWorkModule = module {
        factory { provideHttpInterceptor() }
        factory { AuthenticationInterceptor() }
        factory { OkhttpFactory(get(), get()) }
        single { provideRetrofit(get()) }
        factory { provideRepositoryServiceApi(get()) }
    }
}
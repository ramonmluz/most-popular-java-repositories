package br.com.popularjavareposapp.di

import br.com.popularjavareposapp.data.Repository
import br.com.popularjavareposapp.data.repository.RepositoryImpl
import br.com.popularjavareposapp.ui.viewmodel.RepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val appModule = module {
        single<Repository> { RepositoryImpl(get()) }
        viewModel { RepositoryViewModel(get()) }
    }
}
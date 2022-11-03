package pro.ksart.coinview.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pro.ksart.coinview.data.repository.CoinRepositoryImpl
import pro.ksart.coinview.domain.repository.CoinRepository

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun provideMoviesRepository(impl: CoinRepositoryImpl): CoinRepository
}

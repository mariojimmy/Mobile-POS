package jimmy.mobilepos.di

import jimmy.mobilepos.data.repositories.SettingsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { SettingsRepository(get()) }
}
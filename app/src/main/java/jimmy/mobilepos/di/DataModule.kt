package jimmy.mobilepos.di

import jimmy.mobilepos.data.local.Preferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val prefModule = module {
    single { Preferences(androidContext()) }
}
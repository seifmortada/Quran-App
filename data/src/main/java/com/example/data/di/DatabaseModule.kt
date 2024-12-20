package com.example.data.di


import com.example.data.local.data_source.AzkarJsonDataSource
import com.example.data.local.data_source.QuranJsonDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { androidContext().assets } // Provide AssetManager

    //===============Room Database===========//
    single { provideDatabase(androidContext()) }
    single { provideQuranDao(database = get()) }
    single { provideZikrDao(database = get()) }

    //==============DataSources===========//
    single { QuranJsonDataSource(assetManager = get()) }
    single { AzkarJsonDataSource(assetManager = get()) }

}
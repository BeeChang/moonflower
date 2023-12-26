package com.kmm.moonflower.core.di

import android.content.Context
import com.kmm.moonflower.core.local.DatabaseDriverFactory
import com.kmm.moonflower.features.plants.PlantsRepository
import com.kmm.moonflower.features.plants.usecase.InsertPlantsFromFile
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<SqlDriver>(named("sqlDriver")) {
        DatabaseDriverFactory(get(named("androidContext"))).createDriver()
    }

}

actual fun appDispatcher(): CoroutineDispatcher = Dispatchers.IO

actual class KmmDiModule(applicationContext: Context) {

    val kmmKoin = initKoin(
        module {
            single<Context>(named("androidContext")) { applicationContext }
        }
    )

    val plantsRepository : PlantsRepository by lazy { kmmKoin.koin.get() }

}
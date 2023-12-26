package com.kmm.moonflower.core.di

import com.kmm.moonflower.database.AppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.koinApplication
import org.koin.dsl.module

actual val platformModule = module {
    single<SqlDriver> { NativeSqliteDriver(AppDatabase.Schema, "sunflower.db") }
}

actual fun appDispatcher(): CoroutineDispatcher = Dispatchers.Default
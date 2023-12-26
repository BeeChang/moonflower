package com.kmm.moonflower.core.di

import com.kmm.moonflower.core.local.GardenPlantingDataSource
import com.kmm.moonflower.core.local.GardenPlantingDataSourceImpl
import com.kmm.moonflower.core.local.PlantDataSource
import com.kmm.moonflower.core.local.PlantDataSourceImpl
import com.kmm.moonflower.core.resources.FileResourceReader
import com.kmm.moonflower.core.resources.FileResourceReaderWithCompose
import com.kmm.moonflower.database.AppDatabase
import com.kmm.moonflower.features.graden.GardenPlantingRepository
import com.kmm.moonflower.features.graden.GardenPlantingRepositoryImpl
import com.kmm.moonflower.features.graden.usecase.CheckExistGardenPlanting
import com.kmm.moonflower.features.graden.usecase.CreateGardenPlanting
import com.kmm.moonflower.features.graden.usecase.GetMyGardenPlanting
import com.kmm.moonflower.features.graden.usecase.RemoveGardenPlating
import com.kmm.moonflower.features.plants.usecase.GetPlants
import com.kmm.moonflower.features.plants.usecase.InsertPlantsFromFile
import com.kmm.moonflower.features.plants.PlantsRepository
import com.kmm.moonflower.features.plants.PlantsRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module


expect val platformModule: Module

expect class KmmDiModule

expect fun appDispatcher(): CoroutineDispatcher

val appModule = module {

    single(named("appDispatcher")) { appDispatcher() }

    single<AppDatabase>(named("dbQuery")) {
        AppDatabase(get(named("sqlDriver")))
    }

    single<FileResourceReader>(named("fileResourceReaderWithCompose")) {
        FileResourceReaderWithCompose()
    }
}

val plantsModule = module {

    single<PlantDataSource> {
        PlantDataSourceImpl(
            get(named("dbQuery"))
        )
    }

    single<PlantsRepository> {
        PlantsRepositoryImpl(
            get(),
            get(named("fileResourceReaderWithCompose"))
        )
    }

    factory<InsertPlantsFromFile> {
        InsertPlantsFromFile(
            get(named("fileResourceReaderWithCompose")),
            get(),
            get(named("appDispatcher")),
        )
    }

    factory<GetPlants> {
        GetPlants(
            get(),
            get(named("appDispatcher")),
        )
    }
}

val gardenPlantsModule = module {

    single<GardenPlantingDataSource> {
        GardenPlantingDataSourceImpl(
            get(named("dbQuery"))
        )
    }

    single<GardenPlantingRepository> {
        GardenPlantingRepositoryImpl(
            get(),
        )
    }

    factory<CheckExistGardenPlanting> {
        CheckExistGardenPlanting(
            get(),
            get(named("appDispatcher")),
        )
    }

    factory<CreateGardenPlanting> {
        CreateGardenPlanting(
            get(),
            get(named("appDispatcher")),
        )
    }

    factory<GetMyGardenPlanting> {
        GetMyGardenPlanting(
            get(),
            get(named("appDispatcher")),
        )
    }

    factory<RemoveGardenPlating> {
        RemoveGardenPlating(
            get(),
            get(named("appDispatcher")),
        )
    }

}

fun initKoin(newAdditionalModule: Module): KoinApplication {
    return startKoin {
        modules(newAdditionalModule, platformModule, appModule, plantsModule, gardenPlantsModule)
    }
}


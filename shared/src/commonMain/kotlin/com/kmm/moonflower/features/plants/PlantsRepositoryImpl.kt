package com.kmm.moonflower.features.plants

import com.kmm.moonflower.core.local.PlantDataSource
import com.kmm.moonflower.core.model.database.Plant
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PlantsRepositoryImpl(
    private val plantDataSource: PlantDataSource,
) : PlantsRepository {

    override suspend fun insertPlants(plants: List<Plant>) =
        plantDataSource.insertOrReplacePlants(plants)

    override suspend fun getPlants() = flow {
        emit(plantDataSource.getAllPlants())
    }

    override suspend fun getPlantById(plantId: String) = flow {
        emit(plantDataSource.getPlantById(plantId))
    }

    override suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) = flow {
        emit(plantDataSource.getPlantsWithGrowZoneNumber(growZoneNumber))
    }

}
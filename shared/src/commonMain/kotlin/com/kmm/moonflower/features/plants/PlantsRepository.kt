package com.kmm.moonflower.features.plants

import com.kmm.moonflower.core.model.database.Plant
import kotlinx.coroutines.flow.Flow

interface PlantsRepository {

    suspend fun insertPlatnsJson(filepath: String)
    suspend fun insertPlants(plants: List<Plant>)
    suspend fun getPlants(): Flow<List<Plant>>
    suspend fun getPlantById(plantId: String): Flow<Plant?>
    suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<Plant>>
}
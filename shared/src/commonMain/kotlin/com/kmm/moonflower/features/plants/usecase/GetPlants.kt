package com.kmm.moonflower.features.plants.usecase

import com.kmm.moonflower.features.plants.PlantsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class GetPlants(
    private val plantsRepository: PlantsRepository,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend fun getPlantsById(plantId: String) =
        plantsRepository.getPlantById(plantId)

    suspend fun getPlants() =
        plantsRepository.getPlants()

    suspend fun getPlantsWithZoneNumber(zoneNumber: Int) =
        plantsRepository.getPlantsWithGrowZoneNumber(zoneNumber)

}
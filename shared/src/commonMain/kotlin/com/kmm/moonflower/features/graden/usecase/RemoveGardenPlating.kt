package com.kmm.moonflower.features.graden.usecase

import com.kmm.moonflower.core.model.database.Garden
import com.kmm.moonflower.features.graden.GardenPlantingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoveGardenPlating(
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    suspend fun removePlantInGarden(garden: Garden) = withContext(dispatcher) {
        gardenPlantingRepository.removeGardenPlanting(garden.id)
    }
}
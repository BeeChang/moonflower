package com.kmm.moonflower.features.graden.usecase

import com.kmm.moonflower.core.model.database.Garden
import com.kmm.moonflower.features.graden.GardenPlantingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMyGardenPlanting(
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {

    suspend fun GetGardenPlating(): List<Garden> = withContext(dispatcher) {
        gardenPlantingRepository.getPlantedGardens()
    }
}
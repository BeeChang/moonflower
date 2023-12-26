package com.kmm.moonflower.features.graden.usecase

import com.kmm.moonflower.features.graden.GardenPlantingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock

class CreateGardenPlanting(
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    suspend fun addPlant(plantId: String) = withContext(dispatcher) {
        val nowTimeEpoch = Clock.System.now().toEpochMilliseconds().toInt()
        gardenPlantingRepository.createGardenPlanting(
            plantId = plantId,
            plantDate = nowTimeEpoch,
            lastWateringDate = nowTimeEpoch
        )
    }
}
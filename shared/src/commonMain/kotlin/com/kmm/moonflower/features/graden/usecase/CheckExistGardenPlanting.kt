package com.kmm.moonflower.features.graden.usecase

import com.kmm.moonflower.features.graden.GardenPlantingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CheckExistGardenPlanting(
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {

    suspend fun isPlantInGarden(plantId: String) : Boolean = withContext(dispatcher){
        gardenPlantingRepository.isPlanted(plantId)
    }

}
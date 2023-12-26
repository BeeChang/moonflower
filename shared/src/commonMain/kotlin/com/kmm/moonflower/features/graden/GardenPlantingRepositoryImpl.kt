package com.kmm.moonflower.features.graden

import com.kmm.moonflower.core.local.GardenPlantingDataSource
import database.GardenPlanting
import kotlinx.datetime.Clock

class GardenPlantingRepositoryImpl(
    private val gardenPlantingDataSource: GardenPlantingDataSource,
) : GardenPlantingRepository {

    override suspend fun createGardenPlanting(
        plantId: String,
        plantDate: Int,
        lastWateringDate: Int
    ) {
        gardenPlantingDataSource.insertGardenPlanting(
            plantId = plantId,
            plantDate = plantDate,
            lastWateringDate = lastWateringDate
        )
    }

    override suspend fun removeGardenPlanting(gardenId: Int) =
        gardenPlantingDataSource.deleteGardenPlanting(gardenId)

    override suspend fun isPlanted(plantId: String): Boolean =
        gardenPlantingDataSource.isExistPlantInGardenPlanting(plantId)

    override suspend fun getPlantedGardens() = gardenPlantingDataSource.getGardenPlanting()

}
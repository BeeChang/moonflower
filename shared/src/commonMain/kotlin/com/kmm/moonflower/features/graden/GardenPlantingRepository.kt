package com.kmm.moonflower.features.graden

import com.kmm.moonflower.core.model.database.Garden
import database.GardenPlanting
import kotlinx.datetime.Clock


interface GardenPlantingRepository {

    suspend fun createGardenPlanting(
        plantId: String,
        plantDate: Int,
        lastWateringDate: Int,
    )

    suspend fun removeGardenPlanting(gardenId: Int)

    suspend fun isPlanted(plantId: String): Boolean

    suspend fun getPlantedGardens(): List<Garden>
}
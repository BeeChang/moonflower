package com.kmm.moonflower.features.plants.usecase

import com.kmm.moonflower.core.model.database.Plant
import com.kmm.moonflower.core.resources.FileResourceReader
import com.kmm.moonflower.features.plants.PlantsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class InsertPlantsFromFile(
    private val fileResourceReader: FileResourceReader,
    private val plantsRepository: PlantsRepository,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend fun insertPlantsJsonToDatabase(filepath: String) = withContext(coroutineDispatcher) {
        val platsJson = fileResourceReader.getJsonFileToString(filepath)
        val plants = Json.decodeFromString<List<Plant>>(platsJson)
        plantsRepository.insertPlants(plants)
    }

}


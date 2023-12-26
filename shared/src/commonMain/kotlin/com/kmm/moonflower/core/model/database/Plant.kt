package com.kmm.moonflower.core.model.database

import kotlinx.serialization.Serializable

@Serializable
data class Plant(
    val plantId : String ,
    val name : String,
    val description : String ,
    val growZoneNumber : Int ,
    val wateringInterval :  Int = 7,
    val imageUrl : String = "",
)


package com.kmm.moonflower.android.di

import android.content.Context
import com.kmm.moonflower.android.api.UnsplashService
import com.kmm.moonflower.android.data.AppDatabase
import com.kmm.moonflower.android.data.GardenPlantingDao
import com.kmm.moonflower.core.di.KmmDiModule
import com.kmm.moonflower.features.plants.PlantsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class KMMModule {
    @Singleton
    @Provides
    fun provideKmmDiModule(@ApplicationContext context: Context): KmmDiModule = KmmDiModule(context)

    @Singleton
    @Provides
    fun providePlantsRepository(kmmDiModule: KmmDiModule ): PlantsRepository = kmmDiModule.plantsRepository

}
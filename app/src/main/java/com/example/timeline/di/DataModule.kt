package com.example.timeline.di

import com.example.timeline.data.person.PersonRepositoryImpl
import com.example.timeline.domain.person.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindGetCategories(impl: PersonRepositoryImpl): PersonRepository
}
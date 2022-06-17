package com.example.timeline.di

import com.example.timeline.data.person.PersonRepositoryImpl
import com.example.timeline.domain.person.PersonRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {
    @Binds
    abstract fun providePersonRepository(impl: PersonRepositoryImpl): PersonRepository
}
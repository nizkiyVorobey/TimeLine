package com.example.timeline.domain.person.usecase

import com.example.timeline.domain.person.PersonRepository
import javax.inject.Inject

class GetCategories @Inject constructor(private val personRepository: PersonRepository) {
    suspend fun getCategories() = personRepository.getPersonCategoryList()
}
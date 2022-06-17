package com.example.timeline.domain.person

interface PersonRepository {
    suspend fun getPersonCategoryList(): List<PersonCategory>

    suspend fun getPersonListByCategory(categoryId: Int): List<PersonListItem>
}
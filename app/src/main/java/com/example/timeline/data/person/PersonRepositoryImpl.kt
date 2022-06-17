package com.example.timeline.data.person

import com.example.timeline.domain.person.PersonCategory
import com.example.timeline.domain.person.PersonListItem
import com.example.timeline.domain.person.PersonRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor() : PersonRepository {
    override suspend fun getPersonCategoryList(): List<PersonCategory> {
        val categories = Firebase.firestore.collection("categories").get()
        return categories.await().toObjects(PersonCategory::class.java)
    }

    override suspend fun getPersonListByCategory(categoryId: Int): List<PersonListItem> {
        val persons = Firebase.firestore.collection("persons").get()
        return persons.await().toObjects(PersonListItem::class.java)
    }
}
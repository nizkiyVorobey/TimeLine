package com.example.timeline.data.person

import com.example.timeline.data.mapper.Mapper
import com.example.timeline.domain.person.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class PersonRepositoryImpl @Inject constructor(
    private val mapper: Mapper
) : PersonRepository {
    override suspend fun getPersonCategoryList(): List<PersonCategory> {
        val categories = Firebase.firestore.collection("categories").get()

        return categories.await().toObjects(PersonCategoryServer::class.java)
            .map { mapper.serverPersonCategoryToLocal(it) }
    }

    override suspend fun getPersonListByCategory(categoryId: Int): List<PersonListItem> {
        // TODO
        val persons = Firebase.firestore.collection("persons").get()
        return persons.await().toObjects(PersonListItem::class.java)
    }
}
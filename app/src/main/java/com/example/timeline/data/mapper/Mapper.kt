package com.example.timeline.data.mapper

import com.example.timeline.domain.person.PersonCategory
import com.example.timeline.domain.person.PersonCategoryServer
import com.example.timeline.domain.person.PersonListItem
import com.example.timeline.domain.person.PersonListItemServer
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun serverPersonCategoryToLocal(category: PersonCategoryServer): PersonCategory =
        PersonCategory(
            title = category.title,
            id = category.id,
            isActive = false,
            persons = category.persons.map { serverPersonListItemToLocal(it) }
        )

    private fun serverPersonListItemToLocal(personListItem: PersonListItemServer): PersonListItem =
        PersonListItem(
            avatarUrl = personListItem.avatar,
            firstName = personListItem.first_name ?: "",
            lastName = personListItem.last_name ?: "",
        )
}
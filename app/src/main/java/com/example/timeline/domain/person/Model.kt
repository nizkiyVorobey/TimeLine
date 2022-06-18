package com.example.timeline.domain.person


data class PersonFull(
    val profile: PersonProfile,
)

data class PersonProfile(
    val avatarUrl: String,
    val first_name: String,
    val last_name: String,
    val position: String,
    val description: String,
)

data class PersonListItem(
    val avatarUrl: String? = null,
    val firstName: String = "",
    val lastName: String = "",
    val unreadPostCount: Int = 0 // TODO maybe only for logged/premium user
)

data class PersonCategory (
    val title: String = "",
    val id: Int = 1,
    val isActive: Boolean = false,
    val persons: List<PersonListItem> = emptyList()
)

data class PersonCategoryFilter (
    val title: String = "",
    val id: Int = 1,
    val isActive: Boolean = false,
)

data class PersonCategoryServer(
    val title: String = "",
    val id: Int = 1,
    val persons: List<PersonListItemServer> = emptyList()
)

data class PersonListItemServer(
    val avatar: String? = null,
    val first_name: String? = null,
    val last_name: String? = null,
)
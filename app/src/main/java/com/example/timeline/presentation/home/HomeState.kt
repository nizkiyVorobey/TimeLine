package com.example.timeline.presentation.home

import com.example.timeline.domain.person.PersonCategory
import com.example.timeline.domain.person.PersonCategoryFilter
import com.example.timeline.domain.person.PersonListItem

data class HomeState(
    var filterCategoryList: List<PersonCategoryFilter> = emptyList(),
    var categoryList: List<PersonCategory> = emptyList(),
    var personList: List<PersonListItem> = emptyList(),
    var isCategoryListLoading: Boolean = true,
    var isCategoryListError: LoadingError = LoadingError(),
)

data class LoadingError(
    val isError: Boolean = false,
    val message: String = ""
)

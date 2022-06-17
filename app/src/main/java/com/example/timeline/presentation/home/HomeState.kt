package com.example.timeline.presentation.home

import com.example.timeline.domain.person.PersonCategory

data class HomeState(
    var categoryList: List<PersonCategory> = emptyList(),
    var isCategoryListLoading: Boolean = true,
    var isCategoryListError: LoadingError = LoadingError(),
)

data class LoadingError(
    val isError: Boolean = false,
    val message: String = ""
)

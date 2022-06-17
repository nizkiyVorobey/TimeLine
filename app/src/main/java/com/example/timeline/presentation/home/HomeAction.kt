package com.example.timeline.presentation.home

sealed interface HomeAction {
    data class SelectCategory(val categoryId: Int) : HomeAction
    data class SelectPerson(val personId: Int) : HomeAction
}
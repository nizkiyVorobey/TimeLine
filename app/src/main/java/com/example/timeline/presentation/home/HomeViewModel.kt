package com.example.timeline.presentation.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeline.domain.person.PersonCategoryFilter
import com.example.timeline.domain.person.usecase.GetCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategories: GetCategories
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            val categories = getCategories.getCategories()
//            Timber.d("categories ${categories}")

            Log.d("HomeViewModel", "categories ${categories}")

            state = HomeState(
//                filterCategoryList = categories.mapIndexed { index, personCategory ->
//                    PersonCategoryFilter(
//                        title = personCategory.title,
//                        id = personCategory.id,
//                        isActive = index == 0
//                    )
//                },
                personList = categories.flatMap { it.persons },
                categoryList = categories.mapIndexed { index, personCategory ->
                    personCategory.copy(
                        isActive = index == 0
                    )
                }
            )

//            state.filterCategoryList = categories.mapIndexed { index, personCategory ->
//                PersonCategoryFilter(
//                    title = personCategory.title,
//                    id = personCategory.id,
//                    isActive = index == 0
//                )
//            }

//            Log.d("filterCategoryList", state.filterCategoryList.toString())
//            state.categoryList = categories
        }
    }

    fun onAction(action: HomeAction) {
        when(action) {
            is HomeAction.SelectCategory -> {
                state = state.copy(
                    categoryList=state.categoryList.map {
                        if (action.categoryId == it.id) it.copy(isActive = true)
                        else it.copy(isActive = false)
                    }
                )
                Log.d("SSSS", action.categoryId.toString())
            }
            is HomeAction.SelectPerson -> {}
        }
    }
}
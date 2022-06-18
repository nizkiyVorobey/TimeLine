package com.example.timeline.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timeline.domain.person.PersonCategoryFilter
import com.example.timeline.presentation.home.components.CategoryList
import com.example.timeline.presentation.home.components.PersonList

@Preview(showBackground = true)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    Log.d("filterCategoryListSSSSS", homeViewModel.state.categoryList.toString())
    Column {
        Search()
        CategoryList(
            categoryList = homeViewModel.state.categoryList.map {
                PersonCategoryFilter(
                    title = it.title,
                    id = it.id,
                    isActive = it.isActive
                )
            },
            onAction = homeViewModel::onAction
        )
        PersonList(
            personList = homeViewModel.state.categoryList.find { it.isActive }?.persons
                ?: emptyList()
        )
    }
}
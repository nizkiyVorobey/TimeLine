package com.example.timeline.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.timeline.presentation.home.CategoryList
import com.example.timeline.presentation.home.PersonList
import com.example.timeline.presentation.home.Search

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Column {
        Search()
        CategoryList()
        PersonList()
    }
}
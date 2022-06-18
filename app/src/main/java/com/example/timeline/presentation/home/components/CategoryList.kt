package com.example.timeline.presentation.home.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timeline.domain.person.PersonCategory
import com.example.timeline.domain.person.PersonCategoryFilter
import com.example.timeline.presentation.home.HomeAction


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryListPreview() {
    CategoryList(
        categoryList = listOf(
            PersonCategoryFilter(
                title = "Category 1",
                id = 1,
                isActive = true
            ),
            PersonCategoryFilter(
                title = "Category 2",
                id = 2,
            ),
            PersonCategoryFilter(
                title = "Category 3",
                id = 3,
            ),
            PersonCategoryFilter(
                title = "Category 4",
                id = 4,
            ),
        ),
        onAction = {}
    )
}

@Composable
fun CategoryList(
    categoryList: List<PersonCategoryFilter>,
    onAction: (HomeAction) -> Unit
) {
    Box {
        LazyRow() {
            items(items = categoryList, itemContent = { category ->
                val border = if (category.isActive) {
                    BorderStroke(1.5.dp, Color(0xFF82B366))
                } else {
                    BorderStroke(1.5.dp, Color.Gray)
                }

                val color = if (category.isActive) {
                    Color(0xFFD5E8D4)
                } else {
                    Color.White
                }

                Button(
                    onClick = {
                        onAction(HomeAction.SelectCategory(category.id))
                    },
                    border = border,
                    shape = RoundedCornerShape(50), // = 50% percent
                    colors = ButtonDefaults.buttonColors(
                        containerColor = color,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier.padding(horizontal = 5.dp)
                ) {
                    Text(
                        text = category.title
                    )
                }
            })
        }
    }

}

package com.example.timeline.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryList() {
    var list by remember {
        mutableStateOf(
            listOf(
                PersonCategory(isActive = true, title = "War"),
                PersonCategory(title = "Ecology"),
                PersonCategory(title = "egg"),
                PersonCategory(title = "SS"),
                PersonCategory(title = "DDD"),
                PersonCategory(title = "LLLL"),

                PersonCategory(title = "fe"),
                PersonCategory(title = "ccc"),
                PersonCategory(title = "ccccsd"),
                PersonCategory(title = "sdfce"),
                PersonCategory(title = "LLLcedfegL"),
            )
        )
    }


    Box {
        LazyRow() {
            items(items = list, itemContent = { category ->
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
                        list = list.map {
                            if (it == category) it.copy(isActive = true)
                            else it.copy(isActive = false)
                        }
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

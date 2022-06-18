package com.example.timeline.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.timeline.R
import com.example.timeline.domain.person.PersonCategory
import com.example.timeline.domain.person.PersonListItem

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    val personList by remember {
        mutableStateOf(
            listOf(
                PersonListItem(firstName = "Senya", lastName = "Volkov"),
                PersonListItem(firstName = "Dmytor", lastName = "SSS"),
                PersonListItem(firstName = "Lubov", lastName = "Shuliak"),
                PersonListItem(firstName = "Mykola", lastName = "On"),
                PersonListItem(firstName = "Illya", lastName = "Fedoriv"),

                PersonListItem(firstName = "Senya", lastName = "Volkov"),
                PersonListItem(firstName = "Dmytor", lastName = "SSS"),
                PersonListItem(firstName = "Lubov", lastName = "Shuliak"),
                PersonListItem(firstName = "Mykola", lastName = "On"),
                PersonListItem(firstName = "Illya", lastName = "Fedoriv"),

                PersonListItem(firstName = "Senya", lastName = "Volkov"),
                PersonListItem(firstName = "Dmytor", lastName = "SSS"),
                PersonListItem(firstName = "Lubov", lastName = "Shuliak"),
                PersonListItem(firstName = "Mykola", lastName = "On"),
                PersonListItem(firstName = "Illya", lastName = "Fedoriv"),
            )
        )
    }
    PersonList(personList = personList)
}

@Composable
fun PersonList(
    personList: List<PersonListItem>
) {
    LazyColumn {
        items(personList) { person ->
            Surface(
                shape = RoundedCornerShape(10.dp),
                shadowElevation = 3.dp,
                modifier = Modifier
                    .wrapContentSize(Alignment.TopCenter)
                    .padding(10.dp)
                    .border(
                        width = 1.5.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),

                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(person.avatarUrl ?: R.drawable.person_avatar_placeholder)
                            .crossfade(true)
                            .placeholder(R.drawable.person_avatar_placeholder)
                            .build(),
                        contentScale = ContentScale.Crop,
                        contentDescription = "avatar",
                        modifier = Modifier
                            .clip(CircleShape)
                            .width(130.dp)
                            .height(80.dp)
                    )
                    Text(
                        text = "${person.firstName} ${person.lastName}",
                        modifier = Modifier.padding(start = 160.dp).align(Alignment.CenterStart),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
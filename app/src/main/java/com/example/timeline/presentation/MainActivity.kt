package com.example.timeline.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.timeline.BuildConfig
import com.example.timeline.TimeLineApp
import com.example.timeline.domain.person.PersonRepository
import com.example.timeline.presentation.home.components.HomeScreen
import com.example.timeline.ui.theme.TimeLineTheme
import timber.log.Timber
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject lateinit var  repository: PersonRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        (application as TimeLineApp).appComponent.inject(this)

        setContent {
            TimeLineTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }


    private fun getData() {
        lifecycleScope.launchWhenStarted {
            val res = repository.getPersonCategoryList()
            Timber.d("RES: ${res}")
        }
    }
}

@Composable
fun App() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TimeLineTheme {
        App()
    }
}
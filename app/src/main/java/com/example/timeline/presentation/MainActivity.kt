package com.example.timeline.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timeline.BuildConfig
import com.example.timeline.presentation.home.HomeScreen
import com.example.timeline.ui.theme.TimeLineTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        setContent {
            App()
        }
    }
}

sealed class NavigationDestination(val destination: String) {
    object HomeScreen : NavigationDestination("HomeScreen")
}

@Composable
fun App() {
    TimeLineTheme {
//        val allScreens = TimeLineScreens.values().toList()
//        var currentScreen by rememberSaveable {
//             mutableStateOf(TimeLineScreens.HomeScreen)
//        }
//
//        Box() {
//            currentScreen.content(
//                onScreenChange = { screen ->
//                    currentScreen = TimeLineScreens.valueOf(screen)
//                }
//            )
//        }

        val navController = rememberNavController()

        NavHost(navController, startDestination = NavigationDestination.HomeScreen.destination) {
            composable(NavigationDestination.HomeScreen.destination) {
                HomeScreen()
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TimeLineTheme {
        App()
    }
}
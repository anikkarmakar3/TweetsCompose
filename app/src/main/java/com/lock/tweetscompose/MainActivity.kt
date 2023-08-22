package com.lock.tweetscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lock.tweetscompose.screens.CategoryScreen
import com.lock.tweetscompose.screens.DetailsScreen
import com.lock.tweetscompose.ui.theme.TweetsComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweetsComposeTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }

    @Composable
    private fun App() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "category"){
            composable(route = "category"){
                CategoryScreen{
                    navController.navigate("detail/$it")
                }
            }
            composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )){
                DetailsScreen()
            }
        }
    }
}

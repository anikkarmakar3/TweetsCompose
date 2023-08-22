package com.lock.tweetscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lock.tweetscompose.screens.CategoryScreen
import com.lock.tweetscompose.ui.theme.TweetsComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweetsComposeTheme {
                // A surface container using the 'background' color from the theme
                CategoryScreen()
            }
        }
    }
}

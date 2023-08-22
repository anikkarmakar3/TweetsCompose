package com.lock.tweetscompose.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lock.tweetscompose.viewmodels.DetailsViewModel

@Composable
fun DetailsScreen() {
    val detailsViewModel : DetailsViewModel = hiltViewModel()
    val tweets = detailsViewModel.tweetsListItem.collectAsState()
    LazyColumn(content = {
        items(tweets.value){
            TweetListItem(it.tweet)
        }
    })
}

@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .border(1.dp, Color(0xFFEEEEEE)),
        content = {
            Text(
                text = tweet,
                color = Color.Black,
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.body1
            )
        }
    )
}
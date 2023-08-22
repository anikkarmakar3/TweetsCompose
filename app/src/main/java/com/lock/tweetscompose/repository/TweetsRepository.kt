package com.lock.tweetscompose.repository

import com.lock.tweetscompose.api.TweetsApi
import com.lock.tweetscompose.models.TweetsListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val tweetsApi: TweetsApi) {

    private val _category = MutableStateFlow<List<String>>(emptyList())
        val category : StateFlow<List<String>>
        get() = _category

    private val _tweetItem = MutableStateFlow<List<TweetsListItem>>(emptyList())
        val tweets : StateFlow<List<TweetsListItem>>
        get() = _tweetItem


    suspend fun getCategory() {
        val response = tweetsApi.getCategories().body()
        tweetsApi.getCategories().isSuccessful.let {
            response?.let {
                _category.emit(response)
            }
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweetsApi.getTweetItems(category = category).body()
        tweetsApi.getTweetItems(category = category).isSuccessful.let {
            response?.let {
                _tweetItem.emit(response)
            }
        }
    }


}
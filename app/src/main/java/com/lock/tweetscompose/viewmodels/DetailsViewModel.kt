package com.lock.tweetscompose.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lock.tweetscompose.models.TweetsListItem
import com.lock.tweetscompose.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val tweetsRepository: TweetsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweetsListItem: StateFlow<List<TweetsListItem>>
        get() = tweetsRepository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "Football"
            tweetsRepository.getTweets(category)
        }
    }
}
package com.lock.tweetscompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import com.lock.tweetscompose.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val tweetsRepository: TweetsRepository) :
    ViewModel() {
    val categories: StateFlow<List<String>>
        get() = tweetsRepository.category

    init {
        viewModelScope.launch {
            tweetsRepository.getCategory()
        }
    }
}
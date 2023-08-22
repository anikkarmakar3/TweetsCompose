package com.lock.tweetscompose.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lock.tweetscompose.R
import com.lock.tweetscompose.viewmodels.CategoryViewModel


@Composable
fun CategoryScreen() {
    val categoryViewModel: CategoryViewModel = viewModel()
    val categories = categoryViewModel.categories.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        items(categories.value.distinct()) {
            categoryListItem(category = it)
        }
    }


}


@Composable
fun categoryListItem(category: String) {
    Box(
        modifier = Modifier
            .padding(6.dp)
            .size(120.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painter = painterResource(id = R.drawable.ic_circle_scatter_haikei),
                contentScale = ContentScale.Crop
            ), contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = category,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.h2
        )
    }
}
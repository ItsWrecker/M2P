package com.wrecker.presentation.viewModel.state

import com.wrecker.domain.model.Data

data class DetailsState(
    val data: Data? = null,
    val isLoading: Boolean = false
)
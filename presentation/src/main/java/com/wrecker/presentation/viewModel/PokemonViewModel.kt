package com.wrecker.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.wrecker.domain.interactor.GetPokeMonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor(
    //private val getPokeMonUseCase: GetPokeMonUseCase
) : ViewModel(){

}
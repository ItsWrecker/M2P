package com.wrecker.domain.interactor

interface BaseUseCase<in Parameter, out Result> {
    suspend operator  fun invoke(params: Parameter): Result
}
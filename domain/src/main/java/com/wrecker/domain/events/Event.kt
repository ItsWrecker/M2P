package com.wrecker.domain.events

sealed interface Event<out R> {
    object Loading : Event<Nothing>
    data class Error(val message: String) : Event<Nothing>
    data class Success<R>(val data: R) : Event<R>
}
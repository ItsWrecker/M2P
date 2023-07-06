package dependencies

import Dependencies

object RemoteDependencies {
    const val javax = Dependencies.Inject.javax
    val retrofit = listOf(
        Dependencies.Network.retrofit,
        Dependencies.Network.retrofitConverter,
        Dependencies.Network.loggingIntercepter
    )
    const val coroutine = Dependencies.Kotlin.coroutine

}
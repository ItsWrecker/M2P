package dependencies

import Dependencies

object CacheDependencies {
    const val javax = Dependencies.Inject.javax
    val room = listOf(Dependencies.Room.roomRuntime, Dependencies.Room.roomKtx)
    const val roomKapt = Dependencies.Room.roomCompiler
    const val gson = Dependencies.Network.retrofitGson

    val dataStore = listOf(
        Dependencies.dataStore,
        Dependencies.Kotlin.collection,
        Dependencies.Kotlin.serializer
    )
}
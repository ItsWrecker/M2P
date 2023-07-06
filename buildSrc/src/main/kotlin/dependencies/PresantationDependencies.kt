package dependencies

import Dependencies

object PresantationDependencies {
    const val javax = Dependencies.Inject.javax
    const val coroutine = Dependencies.Kotlin.coroutine

    const val hilt = Dependencies.Inject.hilt
    const val hiltKapt = Dependencies.Inject.hiltCompiler

    val lifeCycle = listOf(
        Dependencies.Core.lifecycle,
        Dependencies.Core.coreKtx,
        Dependencies.Core.viewModelKtx
    )
}
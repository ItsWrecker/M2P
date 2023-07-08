package dependencies

import Dependencies
import Modules

object AppDependencies {

    val core = listOf(
        Dependencies.Core.coreKtx,
        Dependencies.Core.lifecycle,
        Dependencies.Core.viewModelKtx,
        Dependencies.Core.composeActivity
    )

    val compose = listOf(
        Dependencies.Compose.composeUI,
        Dependencies.Compose.composeUIGraphics,
        Dependencies.Compose.composeMaterial,
        Dependencies.Compose.navigation,
        Dependencies.Compose.composePreview,
        Dependencies.Compose.constraintLayout,
        Dependencies.Compose.viewModel
    )

    val hilt = Dependencies.Inject.hilt
    val hiltCompiler = Dependencies.Inject.hiltCompiler

    val glide = Dependencies.glide
}
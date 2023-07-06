import dependencies.RemoteDependencies

plugins {
    id(Config.Plugins.kotlin)
    id(Config.Plugins.javaLibrary)
}


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(Modules.data))
    implementation(RemoteDependencies.coroutine)
    implementation(RemoteDependencies.javax)
    RemoteDependencies.retrofit.forEach {
        implementation(it)
    }
}
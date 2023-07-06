import dependencies.DataDependencies

plugins {
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    api(project(Modules.domain))
    implementation(DataDependencies.javax)
    implementation(DataDependencies.coroutine)
}
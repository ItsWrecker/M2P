import dependencies.DomainDependencies

plugins {
    id(Config.Plugins.javaLibrary)
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation(DomainDependencies.gson)
    implementation(DomainDependencies.coroutine)
    implementation(DomainDependencies.javax)
}
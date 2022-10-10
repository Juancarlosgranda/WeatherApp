plugins {
    `java-library`
    kotlin("jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
dependencies {
    retrofit()
    dagger()
    implementation(Dependencies.coroutines)
    testImplementation(DependenciesTest.junit)
}
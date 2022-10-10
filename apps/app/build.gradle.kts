plugins {
    id("com.android.application")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    kotlin("android")
    id("dagger.hilt.android.plugin")

}
android {
    compileSdk = ConfigAndroid.compileSdk

    defaultConfig {
        applicationId = ConfigAndroid.applicationId
        minSdk = ConfigAndroid.minSdk
        targetSdk = ConfigAndroid.targetSdk
        versionCode = ConfigAndroid.versionCode
        versionName = ConfigAndroid.versionName

        testInstrumentationRunner = ConfigAndroid.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField("String", "BaseURL", "\"https://api.weatherapi.com/v1/\"")

    }

    buildTypes {
        named(BuildEnvironments.release) {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigAndroid.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ConfigAndroid.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes += ConfigAndroid.excludes
        }
    }
}

dependencies {
    implementation(project(":weather-design"))
    implementation(project(":core"))
    implementation(project(":features:location"))
    implementation(project(":features:weather"))
    implementation(Dependencies.core)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.navCompose)
    implementation(Dependencies.composeLifecycle)
    implementation(Dependencies.composeViewModel)
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    dagger()
    daggerAndroid()
    retrofit()
    implementation(Dependencies.coroutines)
    implementation(Dependencies.coroutinesAndroid)
    testImplementation(DependenciesTest.coroutines)
    testImplementation(DependenciesTest.mockk)
    testImplementation(DependenciesTest.junit)
    androidTestImplementation(DependenciesTest.junitAndroid)
    androidTestImplementation(DependenciesTest.espresso)
    androidTestImplementation(DependenciesTest.composeJUnitTest)
    debugImplementation(DependenciesTest.composeUiTooling)
    androidTestImplementation(DependenciesTest.composeUiManifest)
}

kapt {
    correctErrorTypes = true
}

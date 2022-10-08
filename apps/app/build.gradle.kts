plugins {
    id("com.android.application")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    kotlin("android")
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
    }

    buildTypes {
        named(BuildEnvironments.release) {
            isMinifyEnabled = false
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"))
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
    implementation (Dependencies.core)
    implementation (Dependencies.composeUi)
    implementation (Dependencies.composeMaterial)
    implementation (Dependencies.composePreview)
    implementation (Dependencies.lifecycleRuntime)
    implementation (Dependencies.activityCompose)
    //daggerHilt()
    dagger()
    daggerAndroid()
    testImplementation (DependenciesTest.junit)
    androidTestImplementation (DependenciesTest.junitAndroid)
    androidTestImplementation (DependenciesTest.espresso)
    androidTestImplementation (DependenciesTest.composeJUnitTest)
    androidTestImplementation (DependenciesTest.composeUiTooling)
    androidTestImplementation (DependenciesTest.composeUiManifest)
}
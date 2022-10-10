plugins {
    id("com.android.library")
    id("kotlin-kapt")
    kotlin("android")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":weather-design"))
    implementation(project(":core"))
    implementation(project(":features:location-api"))
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
    implementation("io.coil-kt:coil-compose:2.2.0")
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
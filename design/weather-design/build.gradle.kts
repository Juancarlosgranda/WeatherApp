plugins {
    id("com.android.library")
    id("kotlin-kapt")
    kotlin("android")
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.core)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.navCompose)
    implementation(Dependencies.composeLifecycle)
    implementation(Dependencies.composeViewModel)
    dagger()
    daggerAndroid()
    testImplementation(DependenciesTest.junit)
    androidTestImplementation(DependenciesTest.junitAndroid)
    androidTestImplementation(DependenciesTest.composeJUnitTest)
    debugImplementation(DependenciesTest.composeUiTooling)
    androidTestImplementation(DependenciesTest.composeUiManifest)
}
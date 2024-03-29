buildscript {
    dependencies {
        classpath(Dependencies.hiltPlugin)
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Version.gradlePlugin apply false
    id("com.android.library") version "7.3.0" apply false
    kotlin("android") version "1.7.10" apply false
    kotlin("jvm") version "1.7.10" apply false
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}

import org.gradle.api.artifacts.dsl.DependencyHandler


    private fun DependencyHandler.implementation(depName: String) {
        add("implementation", depName)
    }
    private fun DependencyHandler.androidTestImplementation(depName: String) {
        add("androidTestImplementation", depName)
    }
    private fun DependencyHandler.testImplementation(depName: String) {
        add("testImplementation", depName)
    }
    private fun DependencyHandler.kapt(depName: String) {
        add("kapt", depName)
    }
    private fun DependencyHandler.annotationProcessor(depName: String) {
        add("kapt", depName)
    }
    private fun DependencyHandler.compileOnly(depName: String) {
        add("compileOnly", depName)
    }
    private fun DependencyHandler.api(depName: String) {
        add("api", depName)
    }

/**
 * To define plugins
 */
object BuildPlugins {
    val gradleTools by lazy { "com.android.tools.build:gradle:${Version.gradlePlugin}" }
}

object Dependencies {

    val core by lazy { "androidx.core:core-ktx:${Version.core}" }
    val composeUi by lazy { "androidx.compose.ui:ui:${Version.compose}" }
    val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Version.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Version.compose}" }
    val composeLifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-compose:${Version.composeLifecycle}" }
    val composeViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.composeViewModel}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Version.activityCompose}" }
    val navCompose by lazy { "androidx.navigation:navigation-compose:${Version.navCompose}" }

    val hiltPlugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Version.dagger}" }
    val hilt by lazy { "com.google.dagger:hilt-android:${Version.dagger}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Version.dagger}" }
    val dagger by lazy { "com.google.dagger:dagger:${Version.dagger}" }
    val daggerKapt by lazy { "com.google.dagger:dagger-compiler:${Version.dagger}" }
    val daggerAndroid by lazy { "com.google.dagger:dagger-android:${Version.dagger}" }
    val daggerSupport by lazy { "com.google.dagger:dagger-android-support:${Version.dagger}" }
    val daggerProcessor by lazy { "com.google.dagger:dagger-android-processor:${Version.dagger}" }

    val retrofit2 by lazy { "com.squareup.retrofit2:retrofit:${Version.retrofit2}" }
    val retrofit2Converter by lazy { "com.squareup.retrofit2:converter-gson:${Version.retrofit2}" }
    val interceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3}" }
    val gson by lazy { "com.google.code.gson:gson:${Version.gson}" }

    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}" }


}

object DependenciesTest {
    val junit by lazy { "junit:junit:${Version.jUnitTest}" }
    val mockk by lazy { "io.mockk:mockk:${Version.mockk}" }
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}" }

    val junitAndroid by lazy { "androidx.test.ext:junit:${Version.jUnitAndroidTest}" }
    val composeJUnitTest by lazy { "androidx.compose.ui:ui-test-junit4:${Version.compose}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Version.compose}" }
    val composeUiManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Version.compose}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Version.espressoTest}" }

}

fun DependencyHandler.dagger() {
    implementation (Dependencies.dagger)
    kapt (Dependencies.daggerKapt)
}
fun DependencyHandler.daggerAndroid() {
    implementation (Dependencies.daggerAndroid)
    annotationProcessor (Dependencies.daggerProcessor)
}

fun DependencyHandler.retrofit() {
    implementation (Dependencies.retrofit2)
    implementation (Dependencies.interceptor)
    implementation (Dependencies.gson)
    implementation (Dependencies.retrofit2Converter)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.activityCompose)
    androidTestImplementation(DependenciesTest.composeJUnitTest)
    androidTestImplementation(DependenciesTest.composeUiTooling)
    androidTestImplementation(DependenciesTest.composeUiManifest)
}

fun DependencyHandler.jUnitTest() {
    testImplementation(DependenciesTest.junit)
    testImplementation(DependenciesTest.mockk)
    testImplementation(DependenciesTest.coroutines)
    androidTestImplementation(DependenciesTest.junitAndroid)
    androidTestImplementation(DependenciesTest.espresso)
}
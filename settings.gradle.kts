pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "WeatherApp"
include("apps:app")
include("weather-design")
project(":weather-design").projectDir = file("./design/weather-design")
include(":features:location")
include(":features:weather")
include(":core")
include(":features:location-api")

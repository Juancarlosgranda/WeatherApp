<h1 align="center">WeatherApp</h1> 

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=23"><img alt="API" src="https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://ktlint.github.io/"><img alt="API" src="https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg"/></a>
</p>

## About
WeatherApp is an technical Test application for Android devices. With which it will be possible to search and see the weather of different cities.

Build with clean architecture principles and MVVM, using some of the jetpack libraries with Kotlin Coroutines & Dagger Hilt. This App is using Retrofit as a remote data source.

## Architecture

WeatherApp is based on MVVM architecture and Clean Code Architecture using Repository pattern

![image](https://user-images.githubusercontent.com/26071789/156774669-244afd92-ecb4-45ba-afb1-8f6ac0c43027.png)

### Communication between layers 
1. UI calls methods from ViewModel.
2. ViewModel executes Use case.
3. Use case executes one or multiple Repositorie function.
4. The Repository returns data from one or multiple Data Sources. The repository is the single source of truth
5. Information flows back to the UI where we display the data fetched from data sources.

![image](https://user-images.githubusercontent.com/26071789/156774400-9eb0dd63-4496-4a89-8430-04b1da0d2143.png)

### Modules Structure
1. Data:
This is the data layer and consists of the repository implementation class as well as the remote and local data sources and mappers from DTO or Entity to domain models. Data Layer depends on Domain Layer.

2. Domain:
Is the most INNER part of the onion (no dependencies with other layers) and it contains Domain models, Use cases & Repository Interfaces. Use cases combine data from 1 or multiple Repository Interfaces to respect the dependencies rule on the usecases, as they should not be aware of the repositories impl that will be in an upper layer than usecases
We do not have interfaces for usecases and some components following [YAGNI](https://martinfowler.com/bliki/Yagni.html)

3. Presentation:
Contains UI (Activities & Fragments) that are coordinated by ViewModels which execute one or multiple Use cases. Presentation Layer depends on Domain Layer.

4. DI:
This is where Hilt related code lives to inject instances to the rest of application

## Tech stack 
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- [Jetpack suite](https://developer.android.com/jetpack/getting-started)
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
- Architecture
  - MVVM Architecture
  - Android Architecture components
  - Modularization (features and a **Core** module for commons)
  - Repository pattern
- [Retrofit & OkHttp3](https://github.com/square/retrofit).
- [Unit test](https://junit.org/junit4/) 
- Kotlin DSL + BuildSrc for Gradle scripts and better dependency management

## Run the app
-----
- Android Studio Dolphin | 2021.3.1
- In Android Studio, select your app from the run/debug configurations drop-down menu in the toolbar.
- In the toolbar, select the device that you want to run your app on from the target device drop-down menu.
- Click Run .

Android Studio installs your app on your connected device and starts it.
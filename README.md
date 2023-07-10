# M2P

# Pokemon Card Viewer App

This is an Android application built using Kotlin and Jetpack Compose that allows users to view and search for Pokemon cards. The app utilizes Clean Architecture principles and incorporates various libraries such as Hilt, Retrofit, DataStore, and Room Database.

## Features

The Pokemon Card Viewer app provides the following features:

- Display a list of Pokemon cards with the following details:
  - Image
  - Name
  - Types
  - Level
  - HP
- Search for Pokemon cards by name.
- Sort the card list by level and HP.
- View detailed information about a selected Pokemon card:
  - Image
  - Name
  - Types
  - Subtypes
  - Level
  - HP
  - Attacks
  - Weaknesses
  - Abilities
  - Resistances

## Architecture

The app follows the principles of Clean Architecture to achieve separation of concerns and maintain testability. The architecture consists of the following layers:

- **App**: Contains UI logic and all the hilt di thing.
- **Domain Layer**: Contains the business logic and use cases of the application. It defines the interfaces for interacting with the data layer.
- **Data Layer**:  It handles the data sources like Remote, Cache
- **Remote Layer**: Contains all the logic to successfully make the network call and retrieve the data
- **Cache Layer**: Contains offline logic and cache validation logic
- **Presentation Layer**: Contains All the ViewModel and UI States and Interaction logics

## Libraries Used

The following libraries and frameworks were utilized in this project:

- Jetpack Compose: Building the UI components and managing the app's UI.
- Hilt: For dependency injection, providing more straightforward management of dependencies.
- Retrofit: For making HTTP API requests to retrieve Pokemon card data.
- Room Database: For local caching and storage of Pokemon card data.
- DataStore: For storing user preferences such as sorting options.
- Coroutines: For handling asynchronous operations and concurrency.
- MVVM: For the architecture pattern, separating the concerns of the View, ViewModel, and Model.
- Material Design: For designing consistent and visually appealing UI components.

## Installation

To run the app locally, follow these steps:

1. Clone the repository: `git clone https://github.com/ItsWrecker/M2P.git`
2. Open the project in Android Studio.
3. Build the project to resolve dependencies.
4. Run the app on an emulator or a physical device.

## Features

- Offline Support: The app utilizes Room Database to cache Pokemon card data, allowing users to view cards even when offline.
- Flows and Coroutines: Coroutines are used to handle asynchronous operations, and Flows are used for observing data changes in the database and making API requests.
- MVVM: The app follows the Model-View-ViewModel (MVVM) architecture pattern to separate the concerns and improve testability.
- Hilt: Dependency injection is implemented using Hilt, making managing and providing dependencies to various components easier.
- Material Design: The app incorporates Material Design guidelines to create a clean and visually appealing UI.

## Conclusion

The Pokemon Card Viewer app showcases the use of Kotlin, Jetpack Compose, and various other libraries to build an Android application that allows users to explore and search for Pokemon cards. By following Clean Architecture principles, the app achieves modularity, maintainability, and testability. It provides a seamless user experience with features like offline support and material design elements.

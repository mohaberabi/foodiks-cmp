# **Foodiks**

**Foodiks** is a modern **Food Ordering App** built to showcase compose mulyiplatform development

---

## **Features**

- **Food Ordering**: Browse food items, select categories, and add items to the cart.
- **Search Functionality**: Quickly search for food items with real-time updates.
- **Offline Support**: Works offline using Room as a local database.
- **Smooth UI**: Powered by **Jetpack Compose** and Material 3.

---

## **Tech Stack**

### **Core Technologies**

- **Jetpack Compose**: Android new modern declarative UI toolkit.
- **Room**: Local database for offline data storage.
- **Koin**: Kotlin First Services Locator and Dependency injection framework Kotlin and Android
- **Navigation Compose**: Simplified navigation between app screens. using type safe manner
- **Coil**: Fast and lightweight image loading library
- **Ktor Client**: Handles API calls for remote data fetching.

---

## **Architecture**

The app follows a **clean architecture** with the following layers:

1. **Presentation Layer**: Built with Jetpack Compose and ViewModels.
2. **Domain Layer**: Encapsulates business logic using Use Cases.
3. **Data Layer**: Manages data from remote (via Ktor) and local (via Room) sources.

[![Watch the video](https://streamable.com/6uhsqu?src=player-page-share)
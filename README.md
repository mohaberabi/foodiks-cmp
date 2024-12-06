# **Foodiks**

**Foodiks** is a modern **Food Ordering App** built to showcase **Compose Multiplatform**
development. The app demonstrates how to build a shared UI and business logic across Android and iOS
platforms using Kotlin Multiplatform and Jetbrains Compose Multiplatform With The Help Of Jetpack
Multiplatform Libraries .

---

## **Features**

- **Cross-Platform Support**: Shared UI and logic for Android and iOS.
- **Food Ordering**: Browse food items, select categories, and add items to the cart.
- **Search Functionality**: Real-time search for food items with instant updates.
- **Offline Support**: Works offline using a shared data layer with Room (for Android) and
  appropriate iOS storage.
- **Smooth UI**: Powered by **Compose Multiplatform** with Material 3 design principles.

---

## **Tech Stack**

### **Core Technologies**

- **Compose Multiplatform**: Shared UI across Android and iOS using JetBrains Compose.
- **Room Jetpack Multiplatform**: Shared local database implementation for offline support on both
  platforms.
- **Kotlin Multiplatform (KMM)**: Shared business logic and networking code.
- **Koin**: Dependency injection framework for shared and platform-specific modules.
- **Ktor Client**: Networking library for API calls, shared across platforms.
- **Navigation Compose Multiplatform**: Unified and type-safe navigation across Compose screens.
- **Coil Multiplatform**: Shared image loading library for Compose on Android and iOS.

---

## **Architecture**

The app follows a **Clean Architecture** design with a shared structure for business logic and
platform-specific implementations for persistence:

1. **Presentation Layer**:
    - **JetBrains Compose Multiplatform**: A shared declarative UI toolkit for both Android and iOS.
    - **Shared ViewModels**: Built with Kotlin Multiplatform, ensuring consistency across platforms.
2. **Domain Layer**:
    - Encapsulates core business logic using **Use Cases**, shared across Android and iOS.
3. **Data Layer**:
    - **Room Jetpack Multiplatform**: Shared database for offline support.
    - **Ktor Client**: Shared networking code for API calls.

---

## **Demo**

![App Screenshot](https://github.com/mohaberabi/foodiks-cmp/raw/main/screenshoots/android.gif)
![App Screenshot](https://github.com/mohaberabi/foodiks-cmp/raw/main/screenshoots/ios.gif)

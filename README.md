# Hotel App (Android | Java | Firebase)

An Android application built using **Java and Firebase** that allows users to authenticate, browse hotel menus, and view food items with images and prices through a tab-based interface.

---

## Features

* User Login & Registration (Firebase Authentication)
* Show/Hide Password functionality
* Hotel display with image, address, and rating
* Dynamic menu loading from Firebase Realtime Database
* RecyclerView-based menu with images (Glide)
* Tab navigation (Hotel → Menu → Price)

---
## screenshots

![1](https://github.com/user-attachments/assets/e5f20015-33b8-4c29-8e0d-66c9296713dd)
![2](https://github.com/user-attachments/assets/25c8db33-6c01-46f6-a8f5-922ccc257bee)



## Tech Stack

* Java
* Android Studio
* Firebase Authentication
* Firebase Realtime Database
* RecyclerView, ViewPager2, TabLayout
* Glide

---

## App Flow

Login / Register → Hotel Screen → Menu → Select Item → Price Display

---

## Firebase Structure

```
Hotels
 └── Hotel1
      └── menu
           ├── item1
           ├── item2
```

---

## Setup

1. Clone the repository
2. Open in Android Studio
3. Add `google-services.json`
4. Enable Email/Password in Firebase
5. Run the app

---

## Future Improvements

* Cart functionality
* Multiple hotels support
* Search feature

---

## Author

Developed as part of Android development practice using Firebase.

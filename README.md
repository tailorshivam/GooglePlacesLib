
<h1 align="center">Hi 👋, I'm Shivam Tailor</h1>
<h3 align="center">A passionate android developer</h3>

# GooglePlacesLib 🚀
An easy-to-use Google Places API Library for Android.

[![Platform](https://img.shields.io/badge/Platform-Android-brightgreen.svg)](https://developer.android.com/) ![Language](https://img.shields.io/badge/Language-Kotlin-orange.svg) ![Version](https://img.shields.io/badge/Version-1.0.1-blue.svg)

## 📌 Installation
Add JitPack to `settings.gradle.kts`:
```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```
Then, add the dependency:
```kotlin
dependencies {
    implementation("com.github.tailorshivam:GooglePlacesLib:TAG")
}
```
## 🎯 Usage
Initialize in `MainActivity.kt`:
```kotlin
GooglePlaces.initialize(this, "YOUR_API_KEY")

val autoCompleteView = findViewById<PlacesAutoCompleteView>(R.id.placesAutoCompleteView)
autoCompleteView.initialize("YOUR_API_KEY")
```
Add in `activity_main.xml`:
```kotlin
<com.shivam.googleplaceslib.PlacesAutoCompleteView
    android:id="@+id/placesAutoCompleteView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Search places..." />
```

- 📫 How to reach me **tailorshivam141194@gmail.com**
<h3 align="left">Connect with me:</h3>
<p align="left">
<a href="https://linkedin.com/in/shivam-tailor-509833106" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="shivam-tailor-509833106" height="30" width="40" /></a>
<a href="https://stackoverflow.com/users/9581339/tailor-shivam" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/stack-overflow.svg" alt="9581339/tailor-shivam" height="30" width="40" /></a>
</p>























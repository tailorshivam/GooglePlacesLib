package com.example.googleplaceslib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shivam.googleplaceslib.GooglePlaces
import com.shivam.googleplaceslib.PlacesAutoCompleteView
import com.example.googleplaceslib.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Library
        GooglePlaces.initialize(this, "YOUR_API_KEY")

        // Setup AutoCompleteView
        val autoCompleteView = findViewById<PlacesAutoCompleteView>(R.id.placesAutoCompleteView)
        autoCompleteView.initialize("YOUR_API_KEY")
    }
}
package com.shivam.googleplaceslib

import android.content.Context
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatAutoCompleteTextView

/**
 *  Created by Shivam on 25-Feb-25.
 */
class PlacesAutoCompleteView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatAutoCompleteTextView(context, attrs) {

    private lateinit var placesRepository: PlacesRepository

    fun initialize(apiKey: String) {
        placesRepository = PlacesRepository(context, apiKey)
        setupAutoComplete()
    }

    private fun setupAutoComplete() {
        this.threshold = 1
        this.setOnKeyListener { _, _, _ ->
            val query = this.text.toString()
            placesRepository.fetchPlaces(query) { places ->
                val adapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, places)
                this.setAdapter(adapter)
            }
            false
        }
    }
}
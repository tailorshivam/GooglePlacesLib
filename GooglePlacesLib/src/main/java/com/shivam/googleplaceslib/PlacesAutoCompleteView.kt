package com.shivam.googleplaceslib

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *  Created by Shivam on 25-Feb-25.
 */
class PlacesAutoCompleteView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatAutoCompleteTextView(context, attrs) {

    private lateinit var placesRepository: PlacesRepository
    private var searchJob: Job? = null

    fun initialize(apiKey: String) {
        placesRepository = PlacesRepository(context, apiKey)
        setupAutoComplete()
    }

    private fun setupAutoComplete() {
        this.threshold = 1
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                searchJob?.cancel()
                searchJob = CoroutineScope(Dispatchers.Main).launch {
                    delay(500)
                    val query = s.toString()
                    if (query.isNotEmpty()) {
                        placesRepository.fetchPlaces(query) { places ->
                            val adapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, places)
                            this@PlacesAutoCompleteView.setAdapter(adapter)

                            if (!this@PlacesAutoCompleteView.isPopupShowing) {
                                this@PlacesAutoCompleteView.showDropDown()
                            }
                        }
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
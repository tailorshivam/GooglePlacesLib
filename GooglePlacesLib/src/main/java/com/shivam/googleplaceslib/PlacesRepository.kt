package com.shivam.googleplaceslib

import android.content.Context
import android.util.Log
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient

/**
 *  Created by Shivam on 25-Feb-25.
 */
class PlacesRepository(private val context: Context, apiKey: String) {

    private val placesClient: PlacesClient = Places.createClient(context)
    private val sessionToken = AutocompleteSessionToken.newInstance()

    fun fetchPlaces(query: String, callback: (List<String>) -> Unit) {
        val request = FindAutocompletePredictionsRequest.builder()
            .setSessionToken(sessionToken)
            .setQuery(query)
            .build()

        placesClient.findAutocompletePredictions(request)
            .addOnSuccessListener { response ->
                val placeList = response.autocompletePredictions.map { it.getFullText(null).toString() }
                callback(placeList)
            }
            .addOnFailureListener { exception ->
                Log.e("PlacesRepository", "Error fetching places", exception)
                callback(emptyList())
            }
    }
}
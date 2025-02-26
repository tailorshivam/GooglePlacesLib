package com.shivam.googleplaceslib

import android.content.Context
import android.util.Log
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

/**
 *  Created by Shivam on 25-Feb-25.
 */
class PlacesRepository(private val context: Context, apiKey: String) {

    private val placesClient: PlacesClient = Places.createClient(context)
    private val sessionToken = AutocompleteSessionToken.newInstance()

    fun fetchPlaces(query: String, callback: (List<String>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val request = FindAutocompletePredictionsRequest.builder()
                .setSessionToken(sessionToken)
                .setQuery(query)
                .build()

            try {
                val response = placesClient.findAutocompletePredictions(request).await()
                val placeList = response.autocompletePredictions.map { it.getFullText(null).toString() }

                withContext(Dispatchers.Main) {
                    callback(placeList)
                }
            } catch (e: Exception) {
                Log.e("PlacesRepository", "Error fetching places", e)
                withContext(Dispatchers.Main) {
                    callback(emptyList())
                }
            }
        }
    }
}
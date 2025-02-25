package com.shivam.googleplaceslib

import android.content.Context
import com.google.android.libraries.places.api.Places

/**
 *  Created by Shivam on 25-Feb-25.
 */
object GooglePlaces {
    fun initialize(context: Context, apiKey: String) {
        if (!Places.isInitialized()) {
            Places.initialize(context, apiKey)
        }
    }
}

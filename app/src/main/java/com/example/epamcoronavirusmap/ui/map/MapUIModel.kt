package com.example.epamcoronavirusmap.ui.map

import android.graphics.Color
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MapRadius {
    companion object {
        val SMALL: Pair<Int, Int> = Pair(20000, Color.GREEN)
        val MEDIUM: Pair<Int, Int> = Pair(30000, Color.BLUE)
        val BIG: Pair<Int, Int> = Pair(40000, Color.CYAN)
        val HUGE: Pair<Int, Int> = Pair(50000, Color.RED)
    }
}

class Marker {
    companion object {
        const val SMALL_MARKER_COLOR: Float = BitmapDescriptorFactory.HUE_GREEN
        const val MEDIUM_MARKER_COLOR: Float = BitmapDescriptorFactory.HUE_BLUE
        const val BIG_MARKER_COLOR: Float = BitmapDescriptorFactory.HUE_CYAN
        const val HUGE_MARKER_COLOR: Float = BitmapDescriptorFactory.HUE_RED
    }
}

data class MapUIModel(
    val countryName: String,
    val lan: Double,
    val lat: Double,
    val mapCircle: Pair<Int, Int>,
    val markerColor: Float
)

package casas.fabiel.maproutedrawer.data.request

import com.google.android.gms.maps.model.LatLng

interface GoogleApiRequest {
    fun googleKey(): String
    fun sensor(): Boolean
    fun drivingMode(): String
    fun alternatives(): Boolean
    fun origin(): String
    fun destination(): String
}
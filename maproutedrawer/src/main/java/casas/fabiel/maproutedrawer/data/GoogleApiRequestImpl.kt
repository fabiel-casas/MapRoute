package casas.fabiel.maproutedrawer.data

import casas.fabiel.maproutedrawer.CacheData
import com.google.android.gms.maps.model.LatLng

internal class GoogleApiRequestImpl(
    val sensor: Boolean,
    val drivingMode: String,
    val alternatives: Boolean,
    val origin: LatLng,
    val destination: LatLng
) : GoogleApiRequest {

    override fun googleKey(): String {
        return CacheData.googleKey
    }

    override fun sensor(): Boolean {
        return sensor
    }

    override fun drivingMode(): String {
        return drivingMode
    }

    override fun alternatives(): Boolean {
        return alternatives
    }

    override fun origin(): String {
        return "${origin.latitude},${origin.longitude}"
    }

    override fun destination(): String {
        return "${destination.latitude},${destination.longitude}"
    }

}
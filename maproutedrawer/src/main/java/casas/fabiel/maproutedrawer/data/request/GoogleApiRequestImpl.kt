package casas.fabiel.maproutedrawer.data.request

import casas.fabiel.maproutedrawer.CacheData
import com.google.android.gms.maps.model.LatLng

internal class GoogleApiRequestImpl(
    private val sensor: Boolean,
    private val drivingMode: String,
    private val alternatives: Boolean,
    private val origin: LatLng,
    private val destination: LatLng
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
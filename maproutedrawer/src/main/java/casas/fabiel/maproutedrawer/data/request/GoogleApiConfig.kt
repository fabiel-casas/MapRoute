package casas.fabiel.maproutedrawer.data.request

import com.google.android.gms.maps.model.LatLng

class GoogleApiConfig(
    private val sensor: Boolean,
    private val drivingMode: String,
    private val alternatives: Boolean,
    private val origin: LatLng,
    private val destination: LatLng,
    private val googleKey: String
) : GoogleApiRequest {

    override fun googleKey(): String {
        return googleKey
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

    data class Builder(
        private var sensor: Boolean = false,
        private var drivingMode: String = "driving",
        private var alternatives: Boolean = true,
        private var origin: LatLng = LatLng(0.0, 0.0),
        private var destination: LatLng = LatLng(0.0, 0.0),
        private var googleApiKey: String = ""
    ) {

        fun setDestination(destination: LatLng) = apply {
            this.destination = destination
        }

        fun setOrigin(origin: LatLng) = apply {
            this.origin = origin
        }

        fun setAlternatives(alternatives: Boolean) = apply {
            this.alternatives = alternatives
        }

        fun setDrivingMode(drivingMode: String) = apply {
            this.drivingMode = drivingMode
        }

        fun setSensor(sensor: Boolean) = apply {
            this.sensor = sensor
        }

        fun setGoogleApiKey(googleApiKey: String) = apply {
            this.googleApiKey = googleApiKey
        }

        fun build(): GoogleApiRequest = GoogleApiConfig(
            sensor,
            drivingMode,
            alternatives,
            origin,
            destination,
            googleApiKey
        )
    }

}
package casas.fabiel.maproutedrawer.builder

import casas.fabiel.maproutedrawer.data.GoogleApiRequest
import casas.fabiel.maproutedrawer.data.GoogleApiRequestImpl
import com.google.android.gms.maps.model.LatLng

class DrawerConfigurationBuilder {

    private var sensor: Boolean = false
    private var drivingMode: String = "driving"
    private var alternatives: Boolean = true
    private var origin: LatLng = LatLng(0.0, 0.0)
    private var destination: LatLng = LatLng(0.0, 0.0)

    fun setDestination(destination: LatLng): DrawerConfigurationBuilder {
        this.destination = destination
        return this
    }

    fun setOrigin(origin: LatLng): DrawerConfigurationBuilder {
        this.origin = origin
        return this
    }

    fun setAlternatives(alternatives: Boolean): DrawerConfigurationBuilder {
        this.alternatives = alternatives
        return this
    }

    fun setDrivingMode(drivingMode: String): DrawerConfigurationBuilder {
        this.drivingMode = drivingMode
        return this
    }

    fun setSensor(sensor: Boolean): DrawerConfigurationBuilder {
        this.sensor = sensor
        return this
    }

    fun build(): GoogleApiRequest {
        if (origin.latitude == 0.0 && origin.longitude == 0.0) {
            throw Exception("Origin is needed")
        }

        if (destination.latitude == 0.0 && destination.longitude == 0.0) {
            throw Exception("Destination is needed")
        }
        return GoogleApiRequestImpl(
            sensor,
            drivingMode,
            alternatives,
            origin,
            destination
        )
    }
}
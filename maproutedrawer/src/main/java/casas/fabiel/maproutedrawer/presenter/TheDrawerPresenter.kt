package casas.fabiel.maproutedrawer.presenter

import casas.fabiel.maproutedrawer.builder.DrawerConfigurationBuilder
import casas.fabiel.maproutedrawer.data.request.GoogleApiRequest
import casas.fabiel.maproutedrawer.data.request.GoogleApiRequestImpl
import casas.fabiel.maproutedrawer.models.TheDrawerModel
import com.google.android.gms.maps.model.LatLng

class TheDrawerPresenter(val model: TheDrawerModel) {

    private var defaultApiRequest: GoogleApiRequest = DrawerConfigurationBuilder().build()

    fun drawPath(origin: LatLng, destination: LatLng) {
        val localApiRequest = GoogleApiRequestImpl(
            defaultApiRequest.sensor(),
            defaultApiRequest.drivingMode(),
            defaultApiRequest.alternatives(),
            origin,
            destination
        )
        model.getDrawablePath(localApiRequest)
    }

    fun setApiDefaultConfiguration(googleApiRequest: GoogleApiRequest) {
        this.defaultApiRequest = googleApiRequest
    }
}
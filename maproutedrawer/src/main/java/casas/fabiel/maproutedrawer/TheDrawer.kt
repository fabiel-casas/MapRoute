package casas.fabiel.maproutedrawer

import casas.fabiel.maproutedrawer.data.api.GoogleApiDataOrigin
import casas.fabiel.maproutedrawer.data.request.GoogleApiRequest
import casas.fabiel.maproutedrawer.models.TheDrawerModel
import casas.fabiel.maproutedrawer.presenter.TheDrawerPresenter
import com.google.android.gms.maps.model.LatLng

class TheDrawer {

    private var presenter: TheDrawerPresenter

    init {
        val googleApi = GoogleApiDataOrigin()
        val model = TheDrawerModel(googleApi)
        presenter = TheDrawerPresenter(model)
    }

    fun setDefaultApiConfiguration(googleApiRequest: GoogleApiRequest) {
        presenter.setApiDefaultConfiguration(googleApiRequest)
    }

    fun drawPath(origin: LatLng, destination: LatLng) {
        presenter.drawPath(origin, destination)
    }
}
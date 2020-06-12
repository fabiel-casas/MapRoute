package casas.fabiel.maproutedrawer

import casas.fabiel.maproutedrawer.builder.DrawerConfigurationBuilder
import casas.fabiel.maproutedrawer.data.api.GoogleApiDataOrigin
import casas.fabiel.maproutedrawer.models.TheDrawerModel
import casas.fabiel.maproutedrawer.presenter.TheDrawerPresenter
import com.google.android.gms.maps.model.LatLng

class TheDrawerApiManager(
    private val theDrawerListener: TheDrawerListener,
    private val googleApiKey: String
) {

    private var presenter: TheDrawerPresenter

    init {
        val googleApi = GoogleApiDataOrigin()
        val model = TheDrawerModel(googleApi)
        presenter = TheDrawerPresenter(model)
    }

    fun drawPath(origin: LatLng, destination: LatLng) {
        val drawerConfiguration = DrawerConfigurationBuilder()
            .setOrigin(origin)
            .setDestination(destination)
            .setGoogleApiKey(googleApiKey)
            .build()
        presenter.drawPath(drawerConfiguration)
            .subscribe {
                theDrawerListener.drawPolyLines(it)
            }
    }
}
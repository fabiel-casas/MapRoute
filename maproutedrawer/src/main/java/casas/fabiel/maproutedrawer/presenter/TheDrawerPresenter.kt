package casas.fabiel.maproutedrawer.presenter

import casas.fabiel.maproutedrawer.data.request.GoogleApiRequest
import casas.fabiel.maproutedrawer.models.TheDrawerModel
import io.reactivex.Observable

class TheDrawerPresenter(private val model: TheDrawerModel) {

    fun drawPath(googleApiRequest: GoogleApiRequest): Observable<String> {
        return model.getDrawablePath(googleApiRequest)
    }
}
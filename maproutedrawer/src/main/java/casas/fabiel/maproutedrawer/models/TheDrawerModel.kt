package casas.fabiel.maproutedrawer.models

import casas.fabiel.maproutedrawer.data.api.GoogleApiDataOrigin
import casas.fabiel.maproutedrawer.data.request.GoogleApiRequest
import com.google.gson.JsonElement
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class TheDrawerModel(private val googleApi: GoogleApiDataOrigin) {

    fun getDrawablePath(request: GoogleApiRequest): Observable<Response<JsonElement>> {
        return googleApi.getGoogleMapRoute(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
package casas.fabiel.maproutedrawer.models

import casas.fabiel.maproutedrawer.data.api.GoogleApiDataOrigin
import casas.fabiel.maproutedrawer.data.request.GoogleApiRequest
import com.google.gson.JsonElement
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import retrofit2.Response

class TheDrawerModel(private val googleApi: GoogleApiDataOrigin) {

    fun getDrawablePath(request: GoogleApiRequest): Observable<String> {
        return googleApi.getGoogleMapRoute(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                val json = it.body()?.asJsonObject
                val routeArray = json?.getAsJsonArray("routes")
                val routes = routeArray?.get(0)?.asJsonObject
                val overviewPolylines = routes?.getAsJsonObject("overview_polyline")
                val encodedString = overviewPolylines?.getAsJsonObject("points")?.asString
                encodedString
            }
    }
}
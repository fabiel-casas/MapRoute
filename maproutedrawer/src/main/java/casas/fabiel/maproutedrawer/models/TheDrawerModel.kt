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
                return@map if (json?.get("status").toString() == "\"REQUEST_DENIED\"") {
                    throw Exception(json?.get("error_message").toString())
                } else {
                    val routeArray = json?.getAsJsonArray("routes")
                    val routes = routeArray?.get(0)?.asJsonObject
                    val overviewPolylines = routes?.getAsJsonObject("overview_polyline")
                    val encodedString = overviewPolylines?.get("points")?.asString
                    encodedString
                }
            }
    }
}
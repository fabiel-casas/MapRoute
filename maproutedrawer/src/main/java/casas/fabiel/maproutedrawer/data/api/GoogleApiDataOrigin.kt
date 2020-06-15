package casas.fabiel.maproutedrawer.data.api

import casas.fabiel.maproutedrawer.data.request.GoogleApiRequest
import casas.fabiel.maproutedrawer.data.setup.RetrofitConfigurator
import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Response

class GoogleApiDataOrigin {

    private val retrofit: RetrofitConfigurator = RetrofitConfigurator()

    fun getGoogleMapRoute(request: GoogleApiRequest): Observable<Response<JsonElement>> {
        return retrofit.retrofit().create(GoogleApi::class.java)
            .getDefaultMapRout(
                request.origin(),
                request.destination(),
                request.drivingMode(),
                request.drivingMode(),
                request.googleKey(),
                request.sensor()
            )
    }

}
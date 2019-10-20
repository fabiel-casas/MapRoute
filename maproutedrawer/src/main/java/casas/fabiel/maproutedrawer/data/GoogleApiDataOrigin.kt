package casas.fabiel.maproutedrawer.data

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
                request.sensor(),
                request.drivingMode(),
                request.drivingMode(),
                request.googleKey()
            )
    }

}
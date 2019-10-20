package casas.fabiel.maproutedrawer.data

import com.google.gson.JsonElement
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GoogleApi {

    @GET("api/directions/json")
    fun getDefaultMapRout(
        @Path("origin") origin: String,
        @Path("destination") destination: String,
        @Path("sensor") sensor: Boolean,
        @Path("mode") mode: String,
        @Path("alternatives") alternatives: String,
        @Path("key") key: String
    ): Observable<Response<JsonElement>>
}
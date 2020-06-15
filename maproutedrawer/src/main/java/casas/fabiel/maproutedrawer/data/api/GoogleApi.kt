package casas.fabiel.maproutedrawer.data.api

import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleApi {

    @GET("api/directions/json")
    fun getDefaultMapRout(
        @Query("origin") origin: String,
        @Query("destination") destination: String,
        @Query("mode") mode: String,
        @Query("alternatives") alternatives: String,
        @Query("key") key: String,
        @Query("sensor") sensor: Boolean
    ): Observable<Response<JsonElement>>
}
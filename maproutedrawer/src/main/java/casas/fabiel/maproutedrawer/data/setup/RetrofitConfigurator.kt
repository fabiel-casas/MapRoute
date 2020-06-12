package casas.fabiel.maproutedrawer.data.setup

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfigurator {
    private val okHttpClient = OkHttpClient().newBuilder().build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://maps.googleapis.com/maps/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}
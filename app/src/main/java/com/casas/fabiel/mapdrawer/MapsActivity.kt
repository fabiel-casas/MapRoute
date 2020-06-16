package com.casas.fabiel.mapdrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import casas.fabiel.maproutedrawer.drawer.TheDrawer
import casas.fabiel.maproutedrawer.TheDrawerApiManager
import casas.fabiel.maproutedrawer.drawer.data.CameraAnimationMode
import casas.fabiel.maproutedrawer.drawer.data.DrawerConfig
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var amsterdamB: LatLng
    private lateinit var amsterdamA: LatLng
    private lateinit var googleMaps: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        googleMaps = googleMap

        // Add a markers in Amsterdam and load polylines
        amsterdamA = LatLng(52.380726, 4.8836949)
        googleMaps.addMarker(MarkerOptions().position(amsterdamA).title("Marker in Amsterdam A"))
        amsterdamB = LatLng(52.3720804, 4.8963979)
        googleMaps.addMarker(MarkerOptions().position(amsterdamB).title("Marker in Amsterdam B"))
        googleMaps.setOnMapLoadedCallback {
            setupMapRoute()
        }
    }

    private fun setupMapRoute() {
        //create path drawer reference
        val theDrawer = TheDrawer(googleMaps)
        //create drawer configuration
        val theDrawerConfig = DrawerConfig.Builder()
            .setCameraMovementMode(CameraAnimationMode.ANIMATED)
            .build()
        theDrawer.setDrawerConfigurator(theDrawerConfig)
        val drawerApiManager = TheDrawerApiManager(
            theDrawer,
            getString(R.string.google_directions_maps_key)
        )
        drawerApiManager.drawPath(amsterdamA, amsterdamB)
    }
}

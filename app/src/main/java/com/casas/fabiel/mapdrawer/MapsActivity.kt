package com.casas.fabiel.mapdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import casas.fabiel.maproutedrawer.TheDrawer
import casas.fabiel.maproutedrawer.TheDrawerApiManager
import casas.fabiel.maproutedrawer.builder.DrawerConfigurationBuilder

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var amsterdamB: LatLng
    private lateinit var amsterdamA: LatLng
    private lateinit var mMap: GoogleMap

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
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        amsterdamA = LatLng(52.380726, 4.8836949)
        mMap.addMarker(MarkerOptions().position(amsterdamA).title("Marker in Amsterdam A"))
        amsterdamB = LatLng(52.3720804, 4.8963979)
        mMap.addMarker(MarkerOptions().position(amsterdamB).title("Marker in Amsterdam B"))
        mMap.setOnMapLoadedCallback {
            mMap.moveCamera(
                CameraUpdateFactory.newLatLngBounds(
                    LatLngBounds(
                        amsterdamA,
                        amsterdamB
                    ), 12
                )
            )
        }
        setupMapRout()
    }

    private fun setupMapRout() {
        val theDrawer = TheDrawer(mMap)
        val drawerApiManager = TheDrawerApiManager(
            theDrawer,
            getString(R.string.google_maps_key)
        )
        drawerApiManager.drawPath(amsterdamA, amsterdamB)
    }
}

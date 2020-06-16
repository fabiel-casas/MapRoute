package casas.fabiel.maproutedrawer.drawer

import casas.fabiel.maproutedrawer.PolyLineDecoder
import casas.fabiel.maproutedrawer.TheDrawerListener
import casas.fabiel.maproutedrawer.drawer.data.CameraAnimationMode
import casas.fabiel.maproutedrawer.drawer.data.DrawerConfig
import casas.fabiel.maproutedrawer.drawer.data.DrawerConfigurator
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.PolylineOptions

class TheDrawer(private val googleMap: GoogleMap):
    TheDrawerListener {

    private var drawerConfig: DrawerConfigurator = DrawerConfig.Builder().build()

    override fun drawPolyLines(polyLinesEncodes: String) {
        val polyLineDecoder =
            PolyLineDecoder(polyLinesEncodes)
        val polyLineOptions = PolylineOptions()
        polyLineOptions.addAll(polyLineDecoder.polyLinesPoints)
        polyLineOptions.color(drawerConfig.getLineColor())
        polyLineOptions.width(drawerConfig.getStrokeWidth())
        polyLineOptions.clickable(drawerConfig.isClickable())
        polyLineOptions.startCap(drawerConfig.getStartCap())
        polyLineOptions.endCap(drawerConfig.getEndCap())
        googleMap.addPolyline(polyLineOptions)
        val cameraMode = drawerConfig.getCameraMovementOverRoute()
        if (cameraMode != CameraAnimationMode.NONE) {
            moveCameraOverRoute(polyLineDecoder, cameraMode)
        }
    }

    private fun moveCameraOverRoute(
        polyLineDecoder: PolyLineDecoder,
        cameraMode: CameraAnimationMode
    ) {
        val latLngBounds = LatLngBounds.Builder()
        polyLineDecoder.polyLinesPoints.forEach {
            latLngBounds.include(it)
        }
        if (cameraMode == CameraAnimationMode.MOVE) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds.build(), 150))
        } else {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds.build(), 150))
        }
    }

    fun setDrawerConfigurator(drawerConfigurator: DrawerConfigurator) {
        drawerConfig = drawerConfigurator
    }

}
package casas.fabiel.maproutedrawer.drawer

import casas.fabiel.maproutedrawer.PolyLineDecoder
import casas.fabiel.maproutedrawer.TheDrawerListener
import casas.fabiel.maproutedrawer.drawer.data.DrawerConfig
import casas.fabiel.maproutedrawer.drawer.data.DrawerConfigurator
import com.google.android.gms.maps.GoogleMap
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
    }

    fun setDrawerConfigurator(drawerConfigurator: DrawerConfigurator) {
        drawerConfig = drawerConfigurator
    }

}
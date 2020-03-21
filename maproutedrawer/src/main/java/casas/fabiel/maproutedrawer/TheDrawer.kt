package casas.fabiel.maproutedrawer

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.PolylineOptions

class TheDrawer(val googleMap: GoogleMap): TheDrawerListener {

    override fun drawPolyLines(polyLinesEncodes: String) {
        val polyLineDecoder = PolyLineDecoder(polyLinesEncodes)
        val polyLineOptions = PolylineOptions()
        polyLineOptions.addAll(polyLineDecoder.polyLinesPoints)
        googleMap.addPolyline(polyLineOptions)
    }

}
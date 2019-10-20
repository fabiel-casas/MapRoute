package casas.fabiel.maproutedrawer

import com.google.android.gms.maps.model.LatLng
import java.util.ArrayList

class PolyLineDecoder(encoded: String) {

    var polyLinesPoints: ArrayList<LatLng> = ArrayList()

    init {
        encoded.let {
            var index = 0
            val length = it.length
            var latitude = 0
            var longitude = 0

            while (index < length) {
                var basic: Int
                var shift = 0
                var result = 0
                do {
                    basic = it.get(index++).toInt() - 63
                    result = result or (basic and 0x1f shl shift)
                    shift += 5
                } while (basic >= 0x20)
                val deltaLatitude = if (result and 1 != 0) (result shr 1).inv() else result shr 1
                latitude += deltaLatitude
                shift = 0
                result = 0
                do {
                    basic = it.get(index++).toInt() - 63
                    result = result or (basic and 0x1f shl shift)
                    shift += 5
                } while (basic >= 0x20)
                val deltaLongitude = if (result and 1 != 0) (result shr 1).inv() else result shr 1
                longitude += deltaLongitude
                polyLinesPoints.add(
                    LatLng(
                        latitude.toDouble() / 1E5,
                        longitude.toDouble() / 1E5
                    )
                )
            }
        }
    }
}
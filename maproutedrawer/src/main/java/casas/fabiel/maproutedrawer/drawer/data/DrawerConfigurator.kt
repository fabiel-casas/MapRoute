package casas.fabiel.maproutedrawer.drawer.data

import androidx.annotation.ColorInt
import com.google.android.gms.maps.model.Cap

interface DrawerConfigurator {
    @ColorInt fun getLineColor(): Int
    fun getStrokeWidth(): Float
    fun isClickable(): Boolean
    fun getStartCap(): Cap
    fun getEndCap(): Cap
}
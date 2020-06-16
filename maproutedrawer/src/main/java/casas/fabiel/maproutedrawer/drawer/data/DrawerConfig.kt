package casas.fabiel.maproutedrawer.drawer.data

import android.graphics.Color
import androidx.annotation.ColorInt
import com.google.android.gms.maps.model.Cap
import com.google.android.gms.maps.model.RoundCap

class DrawerConfig(
    private val lineColor: Int,
    private val strokeWidth: Float,
    private var isClickable: Boolean = false,
    private var startCap: Cap = RoundCap(),
    private var endCap: Cap = RoundCap()
) : DrawerConfigurator {
    override fun getLineColor(): Int = lineColor
    override fun getStrokeWidth(): Float = strokeWidth
    override fun isClickable(): Boolean = isClickable
    override fun getStartCap(): Cap = startCap
    override fun getEndCap(): Cap = endCap

    data class Builder(
        @ColorInt var lineColor: Int = Color.rgb(35, 154, 222),
        var strokeWidth: Float = 15f,
        var isClickable: Boolean = false,
        var startCap: Cap = RoundCap(),
        var endCap: Cap = RoundCap()
    ) {
        fun setLineColor(lineColor: Int) = apply { this.lineColor = lineColor }
        fun setStrokeWidth(strokeWidth: Float) = apply { this.strokeWidth = strokeWidth }
        fun setClickable(isClickable: Boolean) = apply { this.isClickable = isClickable }
        fun setStartCap(startCap: Cap) = apply { this.startCap = startCap }
        fun setEndCap(endCap: Cap) = apply { this.endCap = endCap }
        fun build(): DrawerConfigurator = DrawerConfig(
            lineColor, strokeWidth, isClickable, startCap, endCap
        )
    }
}
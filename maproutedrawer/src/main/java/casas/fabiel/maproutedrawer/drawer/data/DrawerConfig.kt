package casas.fabiel.maproutedrawer.drawer.data

import android.graphics.Color
import androidx.annotation.ColorInt
import com.google.android.gms.maps.model.Cap
import com.google.android.gms.maps.model.RoundCap

class DrawerConfig private constructor(
    private val lineColor: Int,
    private val strokeWidth: Float,
    private val isClickable: Boolean,
    private val startCap: Cap,
    private val endCap: Cap,
    private val cameraAnimationMode: CameraAnimationMode
) : DrawerConfigurator {
    override fun getLineColor(): Int = lineColor
    override fun getStrokeWidth(): Float = strokeWidth
    override fun isClickable(): Boolean = isClickable
    override fun getStartCap(): Cap = startCap
    override fun getEndCap(): Cap = endCap
    override fun getCameraMovementOverRoute(): CameraAnimationMode = cameraAnimationMode

    data class Builder(
        @ColorInt var lineColor: Int = Color.rgb(35, 154, 222),
        var strokeWidth: Float = 15f,
        var isClickable: Boolean = false,
        var startCap: Cap = RoundCap(),
        var endCap: Cap = RoundCap(),
        var cameraAnimationMode: CameraAnimationMode = CameraAnimationMode.NONE
    ) {
        fun setLineColor(lineColor: Int) = apply { this.lineColor = lineColor }
        fun setStrokeWidth(strokeWidth: Float) = apply { this.strokeWidth = strokeWidth }
        fun setClickable(isClickable: Boolean) = apply { this.isClickable = isClickable }
        fun setStartCap(startCap: Cap) = apply { this.startCap = startCap }
        fun setEndCap(endCap: Cap) = apply { this.endCap = endCap }
        fun setCameraMovementMode(cameraMovementMode: CameraAnimationMode) = apply { this.cameraAnimationMode = cameraMovementMode }
        fun build(): DrawerConfigurator = DrawerConfig(
            lineColor, strokeWidth, isClickable, startCap, endCap, cameraAnimationMode
        )
    }
}
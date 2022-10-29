package com.stone.module16.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.stone.module16.R

class CircularImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : AppCompatImageView(context,attributeSet) {

    var path = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var strokeWidth = 5f
    private var borderColor = Color.WHITE

    init {
        context.withStyledAttributes(attributeSet, R.styleable.CircularImageView){
            borderColor = getColor(R.styleable.CircularImageView_borderColor,borderColor)
            strokeWidth = getDimension(R.styleable.CircularImageView_strokeWidth,strokeWidth)
        }
    }
    override fun onDraw(canvas: Canvas?) {


        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth

        val size = width.coerceAtMost(height)
        // draw border
        canvas?.drawCircle( (size / 2).toFloat(), (size / 2).toFloat(), ((size - strokeWidth) / 2),paint)

        path.addCircle((size / 2).toFloat(), (size / 2).toFloat(), ((size - strokeWidth) / 2), Path.Direction.CCW)
        canvas?.clipPath(path)

        super.onDraw(canvas)
    }
}
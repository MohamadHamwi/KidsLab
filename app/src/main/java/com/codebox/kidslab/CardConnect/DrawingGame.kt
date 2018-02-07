package com.codebox.kidslab.CardConnect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.codebox.kidslab.framework.PixelUtil

/**
 * Created by Abed on 10/9/2017.
 */

class DrawingGame : View {
    var mContext: Context
    var pixel: PixelUtil
    val bounds = RectF()
    val mPoints = Points(0f, 0f)
    constructor(context: Context) : super(context) {
        mContext = context
        pixel = PixelUtil(mContext)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        pixel = PixelUtil(mContext)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        pixel = PixelUtil(mContext)
    }

    lateinit var drawPaint: Paint

    init {
        isFocusable = true
        isFocusableInTouchMode = true
        setupPaint()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val scale = pixel.getDensity()
        val radius = pixel.mScreenX / 10f * scale
        val x = pixel.mScreenX
        val y = pixel.mScreenY

        bounds.set(x / 2f, y / 2 - radius / 2f, x / 2f + radius / 2f, y / 2f + radius / 2f)

        canvas.drawCircle(bounds.left, bounds.top, radius, drawPaint)

        if (!touchPath.isEmpty )

        canvas.drawPoint(mPoints.x,mPoints.y, drawPaint)
    }

    private fun setupPaint() {
        drawPaint = Paint()
        drawPaint.color = Color.RED
        drawPaint.isAntiAlias = true
        drawPaint.strokeWidth = 5f
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
    }

    val touchPath = Path()

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val X = event.x
        val Y = event.y

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {

                    if(isInBounds(X,Y))
                    {
                        mPoints.x = X
                        mPoints.y= Y

                        postInvalidate()
                        return true
                    }

                }
                MotionEvent.ACTION_MOVE -> {
                    if(isInBounds(X,Y)) {

                        mPoints.x = X
                        mPoints.y= Y

                        postInvalidate()
                        return true
                    }
                }
                else -> {
                    return false
                }
            }

        if(isInBounds(X,Y))  postInvalidate()

        return true
    }

    fun isInBounds(x: Float, y: Float): Boolean {
        return bounds.contains(x,y)
    }
    data class Points(var x:Float ,var y:Float)
}

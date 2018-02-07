package com.codebox.kidslab

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.AnimationSet


/**
 * Created by CodeBox on 8/15/2017.
 */
class DrawView(context: Context, attr: AttributeSet) : View(context, attr) {


    var drawPaint: Paint? = null

    init {

        isFocusable = true
        isFocusableInTouchMode = true
        setupPaint()
    }

    fun setupPaint() {
        drawPaint = Paint()
        drawPaint!!.color = Color.BLACK
        drawPaint!!.isAntiAlias = true
        drawPaint!!.strokeWidth = 10f
        drawPaint!!.style = Paint.Style.STROKE
        drawPaint!!.strokeJoin = Paint.Join.ROUND
        drawPaint!!.strokeCap = Paint.Cap.ROUND
        drawPaint!!.style = Paint.Style.STROKE // change back to stroke
        drawPaint!!.setShadowLayer(5*10f,5*10f,-5*10f,Color.BLACK)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val displayMetrics: DisplayMetrics = context.resources.displayMetrics
        val dpHeight = displayMetrics.heightPixels
        val dpWidth = displayMetrics.widthPixels.toFloat()
        // Load the resolution into a Point object

        var myPath = arrayOf<pt>(
                pt(74f * displayMetrics.density, 1f),
                pt(74f * displayMetrics.density, 74f * displayMetrics.density),
                pt(1f, 74f * displayMetrics.density)
        )
        //canvas.drawLine(0f,   25f, dpWidth, 25f, drawPaint)
        /*   canvas.drawLine(6f, 0f, 75f * displayMetrics.density - 6, 0f, drawPaint)
           canvas.drawLine(6f, 75f* displayMetrics.density, 75f * displayMetrics.density - 6, 75f* displayMetrics.density, drawPaint)
           canvas.drawLine(0f, 0f, 0f, 75f * displayMetrics.density, drawPaint)
           canvas.drawLine(75f* displayMetrics.density, 0f, 75f* displayMetrics.density, 75f * displayMetrics.density, drawPaint)
   */
        val path = Path()
        path.moveTo(0f, 0f)

        path.lineTo(myPath[0].xs!!, myPath[0].ys!!)
        path.lineTo(myPath[1].xs!!, myPath[1].ys!!)
        path.lineTo(myPath[2].xs!!, myPath[2].ys!!)
        path.lineTo(0f, 0f)


        canvas!!.drawPath(path, drawPaint)
    }

    class pt(X: Float, Y: Float) {
        var xs: Float? = null
        var ys: Float? = null

        init {
            xs = X
            ys = Y
        }
    }
}
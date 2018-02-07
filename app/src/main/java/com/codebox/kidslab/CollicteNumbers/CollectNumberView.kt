package com.codebox.kidslab.CollicteNumbers

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceView

/**
 * Created by Abed on 10/28/2017.
 */
class CollectNumberView : SurfaceView {
    lateinit var drawPaint: Paint
    var mContext: Context

    constructor(context: Context) : super(context) {
        mContext = context
        init()

    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        init()
    }

    fun init() {
        setupPaint()
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

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        return super.onTouchEvent(event)
    }
}


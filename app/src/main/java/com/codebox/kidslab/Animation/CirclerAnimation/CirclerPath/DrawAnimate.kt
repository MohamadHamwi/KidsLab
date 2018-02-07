package com.codebox.kidslab.Animation.CirclerAnimation.CirclerPath

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.codebox.kidslab.framework.PixelUtil
import com.codebox.kidslab.framework.UIColorHelper

/**
 * Created by Abed on 12/21/2017.
 */
class DrawAnimate : SurfaceView, Runnable, SurfaceHolder.Callback {
    lateinit var mGameThread: Thread
    lateinit var colorGen:UIColorHelper
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        isPaused = true
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        mGameThread = Thread(this)
        mGameThread.start()
    }
var isPaused = false
    var Sx = 0.0f
    var Sy = 0.0f
    var alpha = 0.0
    lateinit var mHolder: SurfaceHolder
    val pixel: PixelUtil
    var runTime = System.currentTimeMillis()
    var updateTimeDraw=runTime
    val convertToSec =1000
    var radius = 0
    override fun run() {
        do {
            if (updateTimeDraw + (1/15) * convertToSec <= runTime && !isPaused && radius < pixel.mScreenX+150) {
                    if (mHolder.surface.isValid) {
                        Sx = pixel.mScreenX / 2f
                        Sy = pixel.mScreenY / 2f
                        radius += 10
                        val mCanvas = mHolder.lockCanvas()
                        mCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR)
                        mCanvas.drawCircle(Sx, Sy, radius.toFloat(), smallCirclePaint())
                        mHolder.unlockCanvasAndPost(mCanvas)
                        runTime = System.currentTimeMillis()
                        updateTimeDraw = runTime
                    }
                } else {
                    runTime = System.currentTimeMillis()
                }

        } while (true)

    }

    val mContext: Context

    constructor(context: Context) : super(context) {
        mContext = context
        pixel = PixelUtil(mContext)
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        pixel = PixelUtil(mContext)
        init()

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        pixel = PixelUtil(mContext)
        init()

    }

    fun init() {
        colorGen = UIColorHelper(mContext)
        mHolder = holder
        mHolder.addCallback(this)
    }

    private fun smallCirclePaint(): Paint {
        val painter = Paint()

        with(painter)
        {
            isDither = true
            color = colorGen.getRandomA700()
            style = Paint.Style.FILL
            isAntiAlias = true
        }

        return painter
    }

    fun resume() {
        isPaused = false
        mGameThread = Thread(this)
        mGameThread.start()
    }
    fun pause(){
        isPaused = true
        mGameThread.interrupt()
    }
}
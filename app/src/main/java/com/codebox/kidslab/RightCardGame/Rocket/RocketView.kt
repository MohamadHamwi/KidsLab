package com.codebox.kidslab.RightCardGame.Rocket


import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.codebox.kidslab.framework.PixelUtil
import java.util.*
import kotlin.collections.ArrayList



class RocketView : SurfaceView, Runnable, SurfaceHolder.Callback {

    var mGameThread: Thread? = null
    lateinit var mHolder: SurfaceHolder
    lateinit var random: Random
    val mContext: Context
    var rocket: ArrayList<Rocket> = ArrayList()
    lateinit var pixel: PixelUtil


    @Volatile
    var mPlaying: Boolean = false

    var mPaused = true

    constructor(context: Context) : super(context) {
        mContext = context
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        init()
    }


    fun init() {
        pixel = PixelUtil(mContext)
        random = Random()
        mHolder = holder
        mHolder.addCallback(this)
        arrayOfRockets()
    }

    var startTime: Long = 0
    override fun run() {
        try {
            while (!mPaused && mPlaying) {

                val Dt = 0.09f + (System.nanoTime() - startTime) / 1000000000.0f
                startTime = System.nanoTime()
                // rocket.drawRocket(holder)
                // Make sure our drawing surface is valid or we crash
                if (mHolder.surface.isValid) {

                    val mCanvas = mHolder.lockCanvas()
                    mCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR)

                    for (i in 0..2) {
                        /*  if (!rocket[i].soundStart1){
                              Dt=0f
                          }*/
                        rocket[i].Update(Dt, mCanvas)
                    }

                    mHolder.unlockCanvasAndPost(mCanvas)

                }
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    fun arrayOfRockets() {

        rocket.add(0, Rocket(mContext))
        rocket.add(1, Rocket(mContext))
        rocket.add(2, Rocket(mContext))

        rocket[0].Xconst = (pixel.mScreenX - rocket[1].RocketImage().width) * 0.25f

        rocket[1].Xconst = (pixel.mScreenX - rocket[0].RocketImage().width) * 0.50f

        rocket[1].dy = pixel.mScreenY.toFloat() - rocket[1].RocketImage().height * 0.25f

        rocket[2].Xconst = (pixel.mScreenX - rocket[1].RocketImage().width) * 0.75f

    }


    fun pause() {
        mPlaying = false
        mPaused = true
        if (mGameThread != null) {
            try {
                mGameThread!!.join()
                mGameThread = null
            } catch (e: InterruptedException) {
                //retry
            }
        }
    }

    fun resume() {
        mPaused = false
        if (mGameThread == null) {
            mPlaying = true
            mGameThread = Thread(this)
            mGameThread!!.start()
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        // TODO Auto-generated method stub
        mGameThread = Thread(this)
        mGameThread!!.start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        // TODO Auto-generated method stub

        mPlaying = false
        mPaused = true
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {

    }
}
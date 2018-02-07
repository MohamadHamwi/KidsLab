package com.codebox.kidslab.iceCream_game.DrawIceCream

import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.codebox.kidslab.framework.Helper
import com.codebox.kidslab.framework.PixelUtil

/**
 * Created by Abed on 10/1/2017.
 */
class IceCreamDraw : SurfaceView, Runnable, SurfaceHolder.Callback {
    var mPaused = false
    var mContext: Context

    lateinit var mGameThread: Thread
    lateinit var mHolder: SurfaceHolder
    lateinit var pixel:PixelUtil
    var creamNum =0
    val arrayOfCream = ArrayList<IceCream>(3)
    var creamArriveToCone = false


    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
        mPaused = true
    }
    override fun surfaceCreated(holder: SurfaceHolder) {
        // TODO Auto-generated method stub
        mGameThread = Thread(this)
        mGameThread.start()
    }


    fun init() {
        pixel= PixelUtil(mContext)
        mHolder = holder
        mHolder.addCallback(this)
        arrayOfCream.add(IceCream(mContext,1))
        arrayOfCream.add(IceCream(mContext,2))
        arrayOfCream.add(IceCream(mContext,3))
    }

    fun changeImage(svgImage:Int)
    {

        arrayOfCream[creamNum].creamImg =svgImage
    }


    var dy = 0f

    override fun run() {
try {
    while (mPaused == false) {
        if (mHolder.surface.isValid) {
            if (dy <=  arrayOfCream[creamNum].stopAnimationAt -  arrayOfCream[creamNum].img().H!!) {
                dy += if(Helper().isTablet(mContext))17 else 10

                val mCanvas = mHolder.lockCanvas()

                mCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
                arrayOfCream[creamNum].drawCream(mCanvas, dy)

                mHolder.unlockCanvasAndPost(mCanvas)
                pixel.mScreenY
                if (dy <=  arrayOfCream[creamNum].stopAnimationAt -  arrayOfCream[creamNum].img().H!!) {
                    creamArriveToCone = true
                }
            }
        }
    }
}catch (e:NullPointerException){

}
    }


    fun onResume()
    {
        mPaused =false
    }
    fun onPaused()
    {
        mPaused =true
    }

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
    fun creamArriveToCone()=creamArriveToCone
}
package com.codebox.kidslab.RightCardGame.Rocket

import android.content.Context
import android.content.res.Configuration
import android.graphics.*
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.ImageUtil
import com.codebox.kidslab.framework.PixelUtil




class Rocket(val mContext: Context) {
    var bounds = RectF()
    lateinit var mMatrix: Matrix
    var pixel: PixelUtil = PixelUtil(mContext)

    var dy = 0f
    var dx = 0f
    var Xconst = 0f
    lateinit var starBounds: RectF

    var stardy = 0f

    var Vo = 0f
    var t = 0f
    var stars: ListStars
    var soundPlayer: SoundPlayer
    var soundStart0 = true
    var soundStart1 = true

    init {
        stars = ListStars(mContext)
        soundPlayer = SoundPlayer(mContext)
        Bounds()
        ParamsInit()
    }

    private fun ParamsInit() {
        if (isTablet() == true) {
            Vo = 50f * pixel.getDensity()
        } else {
            Vo = 40f * pixel.getDensity()
        }
        dy = pixel.mScreenY.toFloat() - RocketImage().height
        Xconst = (pixel.mScreenX - RocketImage().width) * 0.50f

        mMatrix = Matrix()

    }

    private fun Bounds() {
        bounds = RectF()
        starBounds = RectF()

        bounds.left = 0f
        bounds.right = RocketImage().height.toFloat()
        bounds.top = pixel.mScreenY.toFloat() - 200
        bounds.bottom = (pixel.mScreenY - RocketImage().height).toFloat()

        starBounds.left = 0f
        starBounds.right = RocketImage().height.toFloat()
        starBounds.top = pixel.mScreenY.toFloat() - 200
        starBounds.bottom = (pixel.mScreenY - RocketImage().height).toFloat()


    }

    private fun Painter(): Paint {

        val painter = Paint()

        with(painter)
        {
            style = Paint.Style.FILL
            isAntiAlias = true
            isFilterBitmap = true
        }

        return painter
    }

    fun RocketImage(): Bitmap {
        val H = (90 * pixel.getDensity()).toInt()
        val W = (55 * pixel.getDensity()).toInt()
        return ImageUtil().getBitmapFromVectorDrawable(mContext, R.drawable.rocket, W, H)
    }

    fun Update(dt: Float, canvas: Canvas) {

        if (dy <= (pixel.mScreenY /2)) {

            if (soundStart1) {
                soundPlayer.playExplode()
                soundStart1 = false

            }

            stars.updateList(dt, canvas, starMatrix, Painter())

        } else {
            //Vx = Const
            if (soundStart0) {
                soundPlayer.playFireWorks()
                soundStart0 = false

            }
            dy -= Vo * dt
            bounds.offset(Xconst, dy)

            mMatrix.setTranslate(Xconst, dy)
            starChange(dt)
            present(canvas)
        }
    }

    var starMatrix = Matrix()
    var accelY = 20f * pixel.getDensity()
    var Vy = -1 * Vo
    private fun starChange(dt: Float) {
        Vy = -(Vo - accelY * dt)
        t = dx / Vo
        stardy = -(Vo * t + 0.5 * -accelY * Math.pow(t.toDouble(), 2.0)).toFloat()
        if (dy <= (pixel.mScreenY / 2)) {
            starBounds.offset(pixel.mScreenX / 2f - RocketImage().width / 2f, stardy - 150)
            starMatrix.setTranslate(pixel.mScreenX / 2f - RocketImage().width / 2f, bounds.top - 150)


        } else {
            starBounds.offset(dx, stardy)

            starMatrix.setTranslate(starBounds.left, bounds.top)
        }

        stars.startStars(starBounds)
    }

    fun present(canvas: Canvas) {

        canvas.drawBitmap(RocketImage(), mMatrix, Painter())

    }

    fun isTablet(): Boolean {

        return mContext.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }
}

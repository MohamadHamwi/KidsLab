package com.codebox.kidslab.iceCream_game.DrawIceCream

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.Helper
import com.codebox.kidslab.framework.ImageUtil
import com.codebox.kidslab.framework.PixelUtil


class IceCream(val mContext: Context, val creamNum: Int) {
    private val pixel = PixelUtil(mContext)
    private val scale = pixel.getDensity()
    //default value
    var creamImg: Int = R.drawable.ice_cream_yellow
    var stopAnimationAt = 0f

    init {
        dropLocation()
    }

    fun img(): ImageUtil = if (Helper().isTablet(mContext)) ImageUtil(225 * scale, 300 * scale) else ImageUtil(125 * scale, 196 * scale)

    fun creamImage(): Bitmap {
        return img().getBitmapFromVectorDrawable(mContext, creamImg, img().W!!, img().H!!)
    }

    //  img.loadImage(mContext.resources,R.drawable.rocket_effect)
    //
    val displacement = Matrix()
    val dx = pixel.mScreenX / 2 - img().W!! / 2
    fun drawCream(canvas: Canvas, dy: Float)
    {
        displacement.setTranslate(dx.toFloat(), dy)
        canvas.drawBitmap(creamImage(), displacement, paint())
    }

    private fun paint(): Paint {

        val painter = Paint()

        with(painter)
        {
            style = Paint.Style.FILL
            isAntiAlias = true
            isFilterBitmap = true
        }

        return painter
    }

    fun dropLocation() {
        img().getBitmapFromVectorDrawable(mContext, creamImg, img().W!!, img().H!!)
        stopAnimationAt = pixel.mScreenY/2 - creamNum*img().H!!/2f
        if (creamNum==3 && stopAnimationAt < img().H!!){
            stopAnimationAt =  img().H!!+10f
        }

    }
}
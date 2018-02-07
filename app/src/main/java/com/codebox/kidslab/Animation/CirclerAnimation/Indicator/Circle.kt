package com.codebox.kidslab.Animation.CirclerAnimation.Indicator

import android.content.Context
import android.graphics.*
import android.view.View
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.ImageUtil
import com.codebox.kidslab.framework.PixelUtil
import kotlin.math.roundToInt


/**
 * Created by Abed on 11/26/2017.
 */
class Circle(val mContext: Context, val cx: Float, val cy: Float, val r: Float) : View(mContext) {
    val pixel = PixelUtil(mContext)
    val starSize =r.roundToInt()*2-30

    private fun loadImage(): Bitmap =ImageUtil().loadImage(mContext.resources, R.drawable.win_star, starSize,  starSize)

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(cx, cy, r, paint())
        canvas.drawBitmap(loadImage(), cx -starSize/ 2, cy - starSize/ 2, paintImage())

        canvas.drawCircle(cx-r,cy, 10f, smallCirclePaint(mContext.resources.getColor(R.color.Red)))
        canvas.drawCircle(cx,cy-r, 10f, smallCirclePaint(mContext.resources.getColor(R.color.Orange)))
        canvas.drawCircle(cx+r,cy, 10f, smallCirclePaint(mContext.resources.getColor(R.color.Blue)))
        canvas.drawCircle(cx,cy+r, 10f, smallCirclePaint(mContext.resources.getColor(R.color.Green)))


        super.onDraw(canvas)
    }

    private fun paint(): Paint {
        val painter = Paint()

        with(painter)
        {
            isDither = true
            color = mContext.resources.getColor(R.color.Lime)
            style = Paint.Style.STROKE
            strokeWidth = 5f
            isAntiAlias = true
            isFilterBitmap = true
        }

        return painter
    }
    private fun smallCirclePaint(col:Int): Paint {
        val painter = Paint()

        with(painter)
        {
            isDither = true
            color = col
            style = Paint.Style.FILL
            isAntiAlias = true
            isFilterBitmap = true
        }

        return painter
    }
    private fun paintImage(): Paint {
        val painter = Paint()
        with(painter)
        {
            style = Paint.Style.FILL
            isAntiAlias = true
            isFilterBitmap = true
        }
        return painter
    }

}
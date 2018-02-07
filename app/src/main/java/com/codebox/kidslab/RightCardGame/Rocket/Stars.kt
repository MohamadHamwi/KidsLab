package com.codebox.kidslab.RightCardGame.Rocket

import android.graphics.*

/**
 * Created by Abed on 9/27/2017.
 */
 open class Stars {
    var bitmap: Bitmap? = null
    var bounds: RectF? = null

    //initial values
    var dirX: Float = 0.toFloat()
    var dirY: Float = 0.toFloat() //velocity x, y
    var accelX: Float = 0.toFloat()
    var accelY: Float = 0.toFloat() //acceleration x, y

    fun draw(canvas: Canvas, matrix: Matrix,paint: Paint) {
        matrix.setTranslate(bounds!!.left, bounds!!.top)

        canvas.drawBitmap(bitmap!!, matrix, paint)
    }

    fun update(deltaTime: Float,canvas: Canvas, matrix: Matrix,paint: Paint) {
        dirX += accelX * deltaTime
        dirY += accelY * deltaTime

        bounds!!.offset(dirX * deltaTime, dirY * deltaTime)
        draw(canvas, matrix,paint)
    }

    fun isVisible(screenWidth: Int, screenHeight: Int): Boolean {

        return !(bounds!!.right < 0 || bounds!!.left > screenWidth || bounds!!.top > screenHeight || bounds!!.bottom < 0)

    }



}
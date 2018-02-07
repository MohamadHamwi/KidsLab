package com.codebox.kidslab.framework

import android.content.Context
import android.util.DisplayMetrics

/**
 * Defines a scale factor to use for scaling what's displayed
 */
class PixelUtil// Set the screen width and height
(context: Context) {

    private var dm: DisplayMetrics = context.resources.displayMetrics
    var mScreenX:Int
    var mScreenY:Int

    init {
        mScreenX = dm.widthPixels
        mScreenY = dm.heightPixels
         }
    fun getDensity() =  dm.density

/*    fun getDensity(): Float {
        val x = dm.widthPixels
        val y = dm.heightPixels
        if (x < y) {
            val xr = dm.widthPixels / 320.0f
            val yr = dm.heightPixels / 480.0f
            return Math.min(xr, yr)
        } else {//landscape
            val xr = dm.widthPixels / 480.0f
            val yr = dm.heightPixels / 320.0f
            return Math.min(xr, yr)
        }
    }*/

}

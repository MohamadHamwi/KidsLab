package com.codebox.kidslab.RightCardGame.Rocket

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.ImageUtil
import com.codebox.kidslab.framework.PixelUtil
import java.util.*

/**
 * Created by Abed on 9/27/2017.
 */
class ListStars(val mContext: Context) {

    private var stars: ArrayList<Stars>
    private var star: Stars
    private lateinit var starBitmaps: Array<Bitmap?>
    private var random: Random
    private var pixel: PixelUtil

    init {
        star = Stars()
        pixel = PixelUtil(mContext)
        random = Random()
        stars = ArrayList()
        loadStars(mContext.resources)
    }

    private fun loadStars(res: Resources) {
        starBitmaps = Array(7) { null }
        val bs = Math.round(40 * pixel.getDensity())

        starBitmaps[0] = ImageUtil().loadImage(res, R.drawable.star_blue, bs, bs)
        starBitmaps[1] = ImageUtil().loadImage(res, R.drawable.star_green, bs, bs)
        starBitmaps[2] = ImageUtil().loadImage(res, R.drawable.star_orange, bs, bs)
        starBitmaps[3] = ImageUtil().loadImage(res, R.drawable.star_pink, bs, bs)
        starBitmaps[4] = ImageUtil().loadImage(res, R.drawable.star_purple, bs, bs)
        starBitmaps[5] = ImageUtil().loadImage(res, R.drawable.star_red, bs, bs)
        starBitmaps[6] = ImageUtil().loadImage(res, R.drawable.star_yellow, bs, bs)
    }

    fun startStars(bounds: RectF) {
        stars.clear()
        for (i in 0..11) {
            val star = Stars()
            val index = i % starBitmaps.size
            val bitmap = starBitmaps[index]!!
            val size = bitmap.width

            star.bounds = RectF(bounds.centerX() - size / 2, bounds.centerY() - size / 2, bounds.centerX() + size / 2, bounds.centerY() + size / 2)
            star.bitmap = bitmap

            star.dirX = (random.nextInt(200) - 100) * pixel.getDensity() //between -50 and 50
            star.dirY = -(random.nextInt(200) - 100) * pixel.getDensity()  //between -50 and 50
            star.accelX = 10f * pixel.getDensity()
            star.accelY = 30 * pixel.getDensity()  //accelY is gravity

            stars.add(star)
        }
    }


    fun updateList(dt: Float, canvas: Canvas, matrix: Matrix, paint: Paint) {
        for (star in stars) {
            star.update(dt, canvas, matrix, paint)
        }
    }

}
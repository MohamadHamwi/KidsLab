package com.codebox.kidslab.Animation.CirclerAnimation.Indicator

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.codebox.kidslab.framework.Helper
import com.codebox.kidslab.framework.PixelUtil
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.AlphaAnimation



/**
 * Created by Abed on 12/3/2017.
 */
class DrawProgrammatically(val mContext: Context, numberOfPages: Int, val layoutParent: View) {
    private var circle: ArrayList<View> = ArrayList()
    private val pixel = PixelUtil(mContext)
    private val circleX = pixel.mScreenX / (numberOfPages + 1)
    private var circleY=0f
    private val scale = pixel.getDensity()
    fun drawCircle(n: Int) {
        CY()
        getLayoutType()
        circle.add(Circle(mContext, (n + 1) * circleX.toFloat(), circleY, circleX / 3.2f))

        addView(n)
        animation(n)

    }

    fun CY(){
        circleY = if (Helper().isTablet(mContext)) circleX.toFloat() / 2 else pixel.mScreenY- 150* scale
    }
    fun drawThreeCircles(n: Int) {
        CY()
        getLayoutType()
        when (n) {
            0 -> circle.add(Circle(mContext, circleX - 40f * scale, circleY, circleX / 3.2f))
            1 -> circle.add(Circle(mContext, 2f * circleX, circleY, circleX / 3.2f))
            2 -> circle.add(Circle(mContext, 40f * scale + 3 * circleX, circleY, circleX / 3.2f))
        }
        addView(n)
        animation(n)
    }

    var isRelative = false
    var isLinear = false
    var isConstraint = false

   fun animation(n:Int){
       val animation = AlphaAnimation(1f, 0f) // Change alpha from fully visible to invisible
       animation.duration = 500 // duration - half a second
       animation.interpolator = LinearInterpolator() // do not alter animation rate
       animation.repeatCount = 3      // Repeat animation infinitely
       animation.repeatMode = Animation.REVERSE
       circle[n].startAnimation(animation)
   }
    fun addView(n:Int)
    {
               // Reverse animation at the end so the button will fade back in
        if (isRelative)
        (layoutParent as RelativeLayout).addView(circle[n], RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        if (isLinear)
        (layoutParent as LinearLayout).addView(circle[n], RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        if (isConstraint)
        (layoutParent as ConstraintLayout).addView(circle[n], RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
    }

    fun getLayoutType() {
        try {
            (layoutParent as RelativeLayout)
            isRelative=true

           if (!isRelative)
           {
            (layoutParent as LinearLayout)
            isLinear=true
           }
            if(!isRelative && !isLinear)
            {
                (layoutParent as ConstraintLayout)
                isConstraint = true
            }
        } catch (e: TypeCastException) {
            e.printStackTrace()
        }

    }

}
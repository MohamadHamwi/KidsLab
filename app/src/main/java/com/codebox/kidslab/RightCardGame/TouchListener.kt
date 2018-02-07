package com.codebox.kidslab.RightCardGame

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.ViewAnimationUtils
import android.os.Build
import android.support.annotation.RequiresApi
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.SupportVersion.versionSupport


/**
 * Created by CodeBox on 8/12/2017.
 */
class TouchListener(val context:Context) : View.OnTouchListener {
    @SuppressLint("NewApi")
    override fun onTouch(v: View, motionEvent: MotionEvent): Boolean {
        if (motionEvent.action == MotionEvent.ACTION_DOWN)
        {
            val finalRadius = Math.hypot(v.width / 2.000, v.height / 2.000).toFloat()
            val data = ClipData.newPlainText("", "")
            val myDragShadowBuilder = View.DragShadowBuilder(v)
            v.startDrag(data, myDragShadowBuilder, v, 0)
            versionSupport(Build.VERSION_CODES.LOLLIPOP) {
                val anim = ViewAnimationUtils.createCircularReveal(
                        v, v.width / 2, v.height / 2, 0f, finalRadius)
                anim.start()
            }
            v.setBackgroundColor(context.resources.getColor(R.color.tarnsPink))
            return true

        } else {
            v.setBackgroundColor( context.resources.getColor(R.color.white))
            return false
        }
    }

}
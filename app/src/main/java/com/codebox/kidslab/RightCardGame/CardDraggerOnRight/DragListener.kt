package com.codebox.kidslab.RightCardGame.CardDraggerOnRight


import android.animation.Animator
import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v7.view.ContextThemeWrapper
import android.support.v7.widget.CardView
import android.view.DragEvent
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.ImageView
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.UIColorHelper


class DragListener(val correctCard: Int, val imgMain: Int, val context: Context) : View.OnDragListener {
    lateinit var anim: Animator
    val defaultColor = 0
    val updatedColor = 1
    override fun onDrag(v: View, event: DragEvent): Boolean {
        val dragEvent = event.action
        val view = event.localState as View
        val finalRadius = Math.hypot(v.width / 2.000, v.height / 2.000).toFloat()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(v, v.width / 2, v.height / 2, 0f, finalRadius)
        } else {

        }

        when (dragEvent) {
            DragEvent.ACTION_DRAG_EXITED -> {
                backColorChange(v, defaultColor)
                v.setBackgroundColor(context.resources.getColor(R.color.white))
                animationStart()
            }
            DragEvent.ACTION_DRAG_ENTERED -> {

                backColorChange(v, updatedColor)
                v.setBackgroundColor(UIColorHelper().currentUIColor)
                animationStart()
            }
            DragEvent.ACTION_DROP -> {

                if (view.id == correctCard) {
                    backColorChange(v, updatedColor)
                    if ((context as ViewPager_Activity).isLastPage() == false) {
                        MediaPlayer.create(context, R.raw.clapping).start()


                    }
                    (context).nextPage()
                } else {
                    backColorChange(v, defaultColor)
                    MediaPlayer.create(context, R.raw.wrong).start()
                    v.setBackgroundColor(context.resources.getColor(R.color.white))
                    animationStart()
                }

            }
        }
        return true
    }

    private fun animationStart() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anim.start()
        } else {
            //todo
        }
    }

    fun backColorChange(v: View, colorState: Int) {
        val mainImage = (v as CardView).findViewWithTag("MainCard") as ImageView

        val wrapper =
                if (colorState == 1) ContextThemeWrapper(context, R.style.UpdateVector)
                else ContextThemeWrapper(context, R.style.DefaultVector)

        val drawable = VectorDrawableCompat.create(context.resources, imgMain, wrapper.getTheme())
        mainImage.setImageDrawable(drawable)
    }


}


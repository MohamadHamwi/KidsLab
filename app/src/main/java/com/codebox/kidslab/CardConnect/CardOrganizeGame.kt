package com.codebox.kidslab.CardConnect

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.DragEvent
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import com.codebox.kidslab.R
import com.codebox.kidslab.RightCardGame.TouchListener
import kotlinx.android.synthetic.main.activity_card_organize_game.*


class CardOrganizeGame : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }

        setContentView(R.layout.activity_card_organize_game)


        blockOne.setOnTouchListener(TouchListener(this))
        blockTwo.setOnTouchListener(TouchListener(this))
        blockThree.setOnTouchListener(TouchListener(this))
        blockFour.setOnTouchListener(TouchListener(this))

        test1.setOnDragListener(DragListener())
        test2.setOnDragListener(DragListener())
        test3.setOnDragListener(DragListener())
        test4.setOnDragListener(DragListener())

    }



    inner class DragListener : View.OnDragListener {
        override fun onDrag(v: View, event: DragEvent): Boolean {
            val dragEvent = event.action
            val view = event.localState as View

            when (dragEvent) {

                DragEvent.ACTION_DROP -> {
                    val X = event.x
                    val Y = event.y
                    val displayMetrics: DisplayMetrics = resources.displayMetrics
                    if (view.id == R.id.blockOne && v.id == R.id.test1) {


                        val oldParent = view.parent as RelativeLayout
                        oldParent.removeView(view)
                        val newParent = v as RelativeLayout
                     //   test1.visibility=View.GONE
                        newParent.addView(view)
                        v.invalidate()
                        // Load the resolution into a Point object
                    }
                    if (view.id == R.id.blockTwo && v.id == R.id.test2) {


                        val oldParent = view.parent as RelativeLayout
                        oldParent.removeView(view)
                        val newParent = v as RelativeLayout
                      //  test2.visibility=View.GONE
                        newParent.addView(view)
                        v.invalidate()
                        // Load the resolution into a Point object
                    }
                    if (view.id == R.id.blockThree && v.id == R.id.test3) {


                        val oldParent = view.parent as RelativeLayout
                        oldParent.removeView(view)
                        val newParent = v as RelativeLayout
                       // test3.visibility=View.GONE
                        newParent.addView(view)
                        v.invalidate()
                        // Load the resolution into a Point object
                    }
                    if (view.id == R.id.blockFour && v.id == R.id.test4) {


                        val oldParent = view.parent as RelativeLayout
                        oldParent.removeView(view)
                        val newParent = v as RelativeLayout
                      //  test3.visibility=View.GONE
                        newParent.addView(view)
                        v.invalidate()
                        // Load the resolution into a Point object
                    }
                }
            }

            return true
        }
    }

}

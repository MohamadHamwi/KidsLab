package com.codebox.kidslab

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import com.codebox.kidslab.CompleteWordGame.CompleteWordActivity
import com.codebox.kidslab.RightCardGame.CardDraggerOnRight.ViewPager_Activity
import com.codebox.kidslab.framework.SupportVersion.versionSupport
import com.codebox.kidslab.iceCream_game.IceCreamActivity
import kotlinx.android.synthetic.main.main_game_activity.*


class MainGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_game_activity)

        ObjectAnimator.ofObject(
                correctCard          // object we're animating
                , "Correct Card"      // property to animate
                , ArgbEvaluator()           //interpolation function
                , Color.RED, //dy value
                Color.BLACK)                      //end value
                .setDuration(1000)
                .start()

        imageView4.setOnClickListener {

            animationStart(imageView4, TempActivity::class.java)
        }
        correctCard.setOnClickListener {
            animationStart(correctCard, ViewPager_Activity::class.java)
        }
        iceCreamGameLauncher.setOnClickListener {
            animationStart(iceCreamGameLauncher, IceCreamActivity::class.java)
        }
        drawingShapeImg.setOnClickListener {
            animationStart(drawingShapeImg, CompleteWordActivity::class.java)
        }
    }

    override fun onResume() {
        super.onResume()
        imageView4.visibility = View.VISIBLE
        correctCard.visibility = View.VISIBLE
        iceCreamGameLauncher.visibility = View.VISIBLE
        drawingShapeImg.visibility = View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        versionSupport(19) {
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }

    }

    private fun <T> animationStart(V: View, launcher: Class<T>) {

        val animationSet = AnimationSet(this@MainGameActivity, null)
        with(animationSet)
        {
            addAnimation(AlphaAnimation(1f, 0f))
            addAnimation(TranslateAnimation(0f, 0f, 0f, -V.height.toFloat()))
            duration = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()

            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {

                }

                override fun onAnimationEnd(animation: Animation) {
                    V.visibility = View.INVISIBLE
                    startActivity(Intent(this@MainGameActivity, launcher))
                    //  overridePendingTransition(R.anim.abc_slide_out_bottom, R.anim.abc_slide_in_top)
                }

                override fun onAnimationRepeat(animation: Animation) {

                }
            })
            V.startAnimation(animationSet)

        }
    }
}






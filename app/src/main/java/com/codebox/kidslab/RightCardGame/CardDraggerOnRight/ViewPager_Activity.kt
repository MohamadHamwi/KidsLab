package com.codebox.kidslab.RightCardGame.CardDraggerOnRight

import android.graphics.PixelFormat
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.codebox.kidslab.CustomViewPager
import com.codebox.kidslab.framework.Helper
import com.codebox.kidslab.R
import kotlinx.android.synthetic.main.rightcard_activity_game.*


class ViewPager_Activity : AppCompatActivity() {

    lateinit var mAdapter: CustomPagerAdapter
    private lateinit var viewPager: CustomViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Helper().FullScreenCall(this)
        setContentView(R.layout.rightcard_activity_game)

        RocketViewID.setZOrderOnTop(true)    // necessary
        val sfhTrack = RocketViewID.holder
        sfhTrack.setFormat(PixelFormat.TRANSLUCENT)

        mAdapter = CustomPagerAdapter(this@ViewPager_Activity, GameData(this).DataList())
        viewPager = findViewById(R.id.viewpager)

        with(viewPager) {
            adapter = mAdapter
            disableScroll(true)
            //disable sliding in ViewPager manually by Drag
            beginFakeDrag()
            /*To Enable sliding in ViewPager manually by Drag again use this
        viewPager.endFakeDrag();
             */
            //viewPager.setPageTransformer(true, ZoomOutPageTransformer())
        }
    }


    fun startRocketAnimation() {
        RocketViewID.visibility = View.VISIBLE
        RocketViewID.resume()
    }

    fun terminateRocketAnimation() {
        RocketViewID.pause()
        RocketViewID.visibility = View.GONE
        nextPage()
    }

    override fun onResume() {
        super.onResume()
        RocketViewID.resume()
        Helper().FullScreenCall(this)
    }

    override fun onPause() {
        super.onPause()
        RocketViewID.pause()
    }

    fun isLastPage(): Boolean {
        return viewPager.currentItem == mAdapter.count - 1
    }

    var delayTime: Long = 0
    fun nextPage() {
        delayTime = if (Helper().isTablet(this)) 6100 else 5000

        if (isLastPage()) {
            startRocketAnimation()

            Handler().postDelayed({
                terminateRocketAnimation()
                finish()

            }, delayTime)
        } else
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
    }

    fun updateColor() {
        val imgMain: ImageView = viewPager.findViewWithTag<ImageView>("MainCard")
        /*      val theme = resources.newTheme()
              theme.applyStyle(R.style.UpdateVector, false)
              val drawable = imgMain.drawable
              imgMain.setImageDrawable(drawable)*/
        imgMain.background = ContextCompat.getDrawable(this, R.drawable.win_star)
    }
}

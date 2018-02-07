package com.codebox.kidslab.iceCream_game

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.codebox.kidslab.Animation.CirclerAnimation.Indicator.DrawProgrammatically
import com.codebox.kidslab.CustomViewPager
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.Helper
import kotlinx.android.synthetic.main.activity_ice_cream.*


class IceCreamActivity : AppCompatActivity() {


    private lateinit var mAdapter: IceCreamViewPagerAdapter

    var iceCreamDrawMain = ArrayList<View>()
    lateinit var iceCreamViewPager: CustomViewPager
    lateinit var drawStars: DrawProgrammatically
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Helper().FullScreenCall(this)

        setContentView(R.layout.activity_ice_cream)


        iceCreamDrawMain.add(findViewById(R.id.iceCreamDrawMain1))
        iceCreamDrawMain.add(findViewById(R.id.iceCreamDrawMain2))
        iceCreamDrawMain.add(findViewById(R.id.iceCreamDrawMain3))


        mAdapter = IceCreamViewPagerAdapter(this)
        iceCreamViewPager = findViewById(R.id.iceCreamViewPager)
        drawStars = DrawProgrammatically(this, mAdapter.count, IceCreamActivityParent)

        with(iceCreamViewPager) {
            adapter = mAdapter

            disableScroll(true)
            /*To Enable sliding in ViewPager manually by Drag again use this
        viewPager.endFakeDrag();
             */
            //viewPager.setPageTransformer(true, ZoomOutPageTransformer())
        }

    }

    fun drawStars(delayTime: Long) {
        if (mAdapter.count == 3) {
            drawStars.drawThreeCircles(iceCreamViewPager.currentItem)
        } else {
            drawStars.drawCircle(iceCreamViewPager.currentItem)
        }
        Handler().postDelayed({
            if (!isLastPage()) {
                iceCreamViewPager.setCurrentItem(iceCreamViewPager.currentItem + 1, true)
            } else {
                finish()
            }
        }, delayTime)
    }

    fun isLastPage(): Boolean = iceCreamViewPager.currentItem == mAdapter.count - 1

    override fun onResume() {
        super.onResume()
        Helper().FullScreenCall(this)
    }

}



package com.codebox.kidslab.CompleteWordGame

import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.codebox.kidslab.framework.Helper
import com.codebox.kidslab.R
import kotlinx.android.synthetic.main.activity_complete_word.*


class CompleteWordActivity : AppCompatActivity() {
    lateinit var mAdapter: CustomPagerCompleteWord
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Helper().FullScreenCall(this)
        setContentView(R.layout.activity_complete_word)




        mAdapter = CustomPagerCompleteWord(CompleteGameData().loadData(), this@CompleteWordActivity)
        viewPager = findViewById(R.id.CompleteGameViewpager)


        with(viewPager) {
            adapter = mAdapter
            //disable sliding in ViewPager manually by Drag
            beginFakeDrag()
            /*To Enable sliding in ViewPager manually by Drag again use this
        viewPager.endFakeDrag();
             */
            //viewPager.setPageTransformer(true, ZoomOutPageTransformer())
        }

       indicator.setViewPager(viewPager)



    }

    fun isLastPage(): Boolean = viewPager.currentItem == mAdapter.count - 1
    fun nextPage() {

        Handler().postDelayed({
            if (!isLastPage()) viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        else finish()

    }, 1100)


    }
    override fun onResume() {
        super.onResume()
        Helper().FullScreenCall(this)
    }
    fun replaceText(winChar:Char, txt:String){
        val textQuest = viewPager.findViewWithTag<TextView>("Quest"+viewPager.currentItem )
        textQuest.text=winChar.toString()
        val coloredTextQuest = mAdapter.getColoredSpanned(txt, "#000")
        mAdapter.appendColoredText(textQuest, coloredTextQuest)

    }

}


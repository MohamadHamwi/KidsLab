package com.codebox.kidslab

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by Abed on 2/5/2018.
 */

class CustomViewPager : ViewPager {
    private var disable: Boolean? = false

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (disable!!) false else super.onInterceptTouchEvent(event)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (disable!!) false else super.onTouchEvent(event)
    }

    fun disableScroll(disable: Boolean?) {
        //When disable = true not work the scroll and when disble = false work the scroll
        this.disable = disable
    }
}
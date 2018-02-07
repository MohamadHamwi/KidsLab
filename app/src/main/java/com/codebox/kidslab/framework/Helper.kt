package com.codebox.kidslab.framework


import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.util.Log
import android.view.View



class Helper {

    fun FullScreenCall( activity: Activity) {
        if (Build.VERSION.SDK_INT < 19) { // lower api
            val v = activity.window.decorView
            v.systemUiVisibility = View.GONE
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            val decorView = activity.window.decorView

            val uiOptions = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

            decorView.systemUiVisibility = uiOptions
        }
    }

    fun isTablet(mContext:Context): Boolean {

        return mContext.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }
}

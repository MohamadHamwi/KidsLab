package com.codebox.kidslab

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codebox.kidslab.framework.Helper
import kotlinx.android.synthetic.main.activity_temp.*


class TempActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        Helper().FullScreenCall(this)
        drawPath.resume()
    }

    override fun onResume() {
        super.onResume()
        drawPath.resume()
        Helper().FullScreenCall(this)
    }

    override fun onPause()
    {
        super.onPause()
        drawPath.pause()
    }
}

package com.codebox.kidslab.framework

import android.content.Context
import com.codebox.kidslab.R
import java.util.*

/**
 * Created by CodeBox on 9/18/2017.
 */

class UIColorHelper() {
    var currentUIColor:Int=0
    lateinit var mContext:Context
    constructor( Context: Context):this()
    {
        mContext=Context
    }
    fun getRandomA700(): Int {
        val rnd = Random().nextInt(A700Colors().size-1)
        return A700Colors()[rnd]
    }
    private fun A700Colors(): IntArray = mContext.resources.getIntArray(R.array.A700)

}

package com.codebox.kidslab.RightCardGame.CardDraggerOnRight

import android.app.Activity

/**
 * Created by CodeBox on 8/13/2017.
 */
data class Model
(val Img1: Int,val Img2: Int,val Img3: Int,val ImgMain: Int
 ,val WinierCardID: Int,val ToastMessage: String,val Activity: Activity)

val <T> ArrayList<T>.lastIndex: Int
    get() = size - 1
val arr = ArrayList<Model>()
fun local(){
    arr.lastIndex
}
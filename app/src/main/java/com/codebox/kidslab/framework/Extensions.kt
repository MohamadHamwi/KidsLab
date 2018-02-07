package com.codebox.kidslab.framework

import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arrow.core.None
import arrow.core.Option
import arrow.core.Some

/**
 * Created by Abed on 12/23/2017.
 */

fun Any?.toString(): String {
    if (this == null)
        return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}

val <T> List<T>.lastIndex: Int
    get() = size - 1

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}
fun arrow_io_ex(){
    val someValue: Option<Double> = Some(20.1)
    val value = when(someValue) {
        is Some -> someValue.t
        is None -> 0.0
    }
}
fun Char.isLatinUpperCase(){
    this.isUpperCase()
}
fun View.snackbar(message: CharSequence, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).setAction("Action", null).show()
}
//Array-like operations a[i] == a.get(i)
operator fun ViewGroup.get(position: Int): View = getChildAt(position)

fun ViewGroup.inflater(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}
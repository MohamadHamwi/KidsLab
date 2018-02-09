package com.codebox.kidslab.Progress

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.content.edit


/**
 * Created by Abed on 12/14/2017.
 */
class DataFactory : Application() {
    companion object {
        lateinit var instance: DataFactory
        lateinit var mPref: SharedPreferences
                /* The private set is used
                 so that a value can’t be assigned from an external class.*/
            private set
    }

    private val DATA_KEY = "KidsLab"
    override fun onCreate() {
        super.onCreate()
        instance = this
        mPref = getSharedPreferences(DATA_KEY, Context.MODE_PRIVATE)
    }

    fun getInt(key: Int): Int {
        return mPref.getInt(key.toString(), 0)
    }

    fun getDouble(key: String): Double {
        return mPref.getString(key, "0.0").toDouble()
    }

    fun getStr(key: Int): String {
        return mPref.getString(key.toString(), "No data")
    }

    fun put(key: Int, `val`: String) {

        mPref.edit {
            putString(key.toString(), `val`)
        }
    }


    fun put(key: String, `val`: Int) {
        mPref.edit {
            putInt(key, `val`)
        }
    }


    fun put(key: String, `val`: Boolean) {
        mPref.edit {
            putBoolean(key, `val`)
        }

    }


    fun put(key: String, `val`: Float) {
        mPref.edit {
            putFloat(key, `val`)
        }
    }

    /**
     *
     * Convenience method for storing doubles.
     *
     *
     *
     * There may be instances where the accuracy of a double is desired.
     *
     * SharedPreferences does not handle doubles so they have to
     *
     * cast to and from String.
     *
     *
     *
     * @param key The name of the preference to store.
     *
     * @param val The new value for the preference.
     */

    fun put(key: String, `val`: Double) {
        mPref.edit {
            putString(key, `val`.toString())
        }
    }

    fun remove(key: Int) {
        mPref.edit {
            remove(key.toString())
        }
    }

    /**
     *
     * Remove all keys from SharedPreferences.
     *
     */
    fun clear() {
        mPref.edit {
            clear()
        }
    }
}
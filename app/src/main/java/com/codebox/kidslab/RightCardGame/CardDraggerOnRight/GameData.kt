package com.codebox.kidslab.RightCardGame.CardDraggerOnRight

import android.app.Activity
import com.codebox.kidslab.R
import java.util.*

/**
 * Created by CodeBox on 9/19/2017.
 */
class GameData()
{

    lateinit var activity: Activity

    constructor(mActivity: Activity) : this()
    {
        activity = mActivity
    }

    private val dataList:MutableList<Model> = mutableListOf<Model>()

    fun DataList(): MutableList<Model> {

        dataList.add(0,Model(R.drawable.stars, R.drawable.candy, R.drawable.suns, R.drawable.one, R.id.cardView2, "One", activity))
        dataList.add(1,Model(R.drawable.suns, R.drawable.candy, R.drawable.stars, R.drawable.two, R.id.cardView1, "Two", activity))
        dataList.add(2,Model(R.drawable.stars, R.drawable.suns, R.drawable.candy, R.drawable.three, R.id.cardView1, "Three", activity))

        Collections.shuffle(dataList)

        return dataList

    }

}
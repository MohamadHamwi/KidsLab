package com.codebox.kidslab.iceCream_game.GameData

import com.codebox.kidslab.Progress.DataFactory
import com.codebox.kidslab.R
import java.util.*


/**
 * Created by Abed on 10/2/2017.
 */

class IceCreamGameData() {
    private val dataList: MutableList<IceCreamModel> = mutableListOf<IceCreamModel>()
    private var rand = Random()
    var gameData = mutableListOf<IceCreamModel>()
    private val LEVEL_KEY = "Level"
    private val dataStorage = DataFactory.instance

    val levelState = dataStorage.getDouble(LEVEL_KEY)

    var n = 1

    private fun gameList0() {
        dataList.add(IceCreamModel(R.drawable.ice_cream_red, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, null, null, "Red", R.drawable.ice_cream_red))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, R.drawable.ice_cream_green, null, null, "Red", R.drawable.ice_cream_red))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, null, null, "Red", R.drawable.ice_cream_red))

        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, null, null, "Green", R.drawable.ice_cream_green))
        dataList.add(IceCreamModel(R.drawable.ice_cream_red, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, null, null, "Green", R.drawable.ice_cream_green))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, R.drawable.ice_cream_green, null, null, "Green", R.drawable.ice_cream_green))

        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, R.drawable.ice_cream_green, null, null, "Yellow", R.drawable.ice_cream_yellow))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, null, null, "Yellow", R.drawable.ice_cream_yellow))
        dataList.add(IceCreamModel(R.drawable.ice_cream_red, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, null, null, "Yellow", R.drawable.ice_cream_yellow))
    }

    private fun gameList1() {
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, null, null, "Blue", R.drawable.ice_cream_blue))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_green, null, null, "Blue", R.drawable.ice_cream_blue))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, null, null, "Blue", R.drawable.ice_cream_blue))

        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_red,null, "Red", R.drawable.ice_cream_red))
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_red, R.drawable.ice_cream_yellow,null, "Green", R.drawable.ice_cream_green))
        dataList.add(IceCreamModel(R.drawable.ice_cream_red, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_green,null,"Green", R.drawable.ice_cream_green))

        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_green, null, null, "Yellow", R.drawable.ice_cream_yellow))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, null, null, "Yellow", R.drawable.ice_cream_yellow))
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, null, null, "Yellow", R.drawable.ice_cream_yellow))
    }

    private fun gameList2() {
        dataList.add(IceCreamModel(R.drawable.ice_cream_orange, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, null, null, "Orange", R.drawable.ice_cream_orange))
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_orange, R.drawable.ice_cream_green, null, null, "Orange", R.drawable.ice_cream_orange))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_blue, R.drawable.ice_cream_orange, null, null, "Orange", R.drawable.ice_cream_orange))

        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_orange, R.drawable.ice_cream_blue, R.drawable.ice_cream_red, R.drawable.ice_cream_yellow, "Green", R.drawable.ice_cream_green))
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange, R.drawable.ice_cream_red, "Red", R.drawable.ice_cream_red))
        dataList.add(IceCreamModel(R.drawable.ice_cream_red, R.drawable.ice_cream_orange, R.drawable.ice_cream_yellow, R.drawable.ice_cream_green, R.drawable.ice_cream_blue, "Red", R.drawable.ice_cream_red))

        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_red, R.drawable.ice_cream_orange, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, "Blue", R.drawable.ice_cream_blue))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_red, R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange, R.drawable.ice_cream_blue, "Yellow", R.drawable.ice_cream_yellow))
        dataList.add(IceCreamModel(R.drawable.ice_cream_orange, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, R.drawable.ice_cream_blue, "Blue", R.drawable.ice_cream_blue))

    }

    private fun gameList3() {
        dataList.add(IceCreamModel(R.drawable.ice_cream_brown, R.drawable.ice_cream_green, R.drawable.ice_cream_red, null, null, "brown", R.drawable.ice_cream_brown))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange, R.drawable.ice_cream_brown, R.drawable.ice_cream_green, null, "brown", R.drawable.ice_cream_brown))
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue,R.drawable.ice_cream_brown, R.drawable.ice_cream_red, R.drawable.ice_cream_yellow, null, "brown", R.drawable.ice_cream_brown))

        dataList.add(IceCreamModel(R.drawable.ice_cream_orange, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_red, "Orange", R.drawable.ice_cream_orange))
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, R.drawable.ice_cream_orange, "Green", R.drawable.ice_cream_green))
        dataList.add(IceCreamModel(R.drawable.ice_cream_red, R.drawable.ice_cream_orange, R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_brown, "Orange", R.drawable.ice_cream_orange))

        dataList.add(IceCreamModel(R.drawable.ice_cream_green,R.drawable.ice_cream_red, R.drawable.ice_cream_brown, R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange, "Red", R.drawable.ice_cream_red))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange, R.drawable.ice_cream_red, R.drawable.ice_cream_blue, R.drawable.ice_cream_green, "Blue", R.drawable.ice_cream_blue))
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_brown, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, "Blue", R.drawable.ice_cream_blue))
    }

    private fun gameList4() {
        dataList.add(IceCreamModel(R.drawable.ice_cream_brown,R.drawable.ice_cream_blue, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, "brown", R.drawable.ice_cream_brown))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_red,R.drawable.ice_cream_orange, R.drawable.ice_cream_brown, R.drawable.ice_cream_green, "brown", R.drawable.ice_cream_brown))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow,R.drawable.ice_cream_blue, R.drawable.ice_cream_red, R.drawable.ice_cream_brown, "brown", R.drawable.ice_cream_brown))

        dataList.add(IceCreamModel(R.drawable.ice_cream_orange, R.drawable.ice_cream_brown, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, "Orange", R.drawable.ice_cream_orange))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_brown, R.drawable.ice_cream_blue, R.drawable.ice_cream_orange, R.drawable.ice_cream_green, "Orange", R.drawable.ice_cream_orange))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_brown, R.drawable.ice_cream_orange, "Orange", R.drawable.ice_cream_orange))

        dataList.add(IceCreamModel(R.drawable.ice_cream_brown, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_orange, "Blue", R.drawable.ice_cream_blue))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_orange, R.drawable.ice_cream_brown, R.drawable.ice_cream_green, "Blue", R.drawable.ice_cream_blue))
        dataList.add(IceCreamModel(R.drawable.ice_cream_orange,R.drawable.ice_cream_green, R.drawable.ice_cream_brown, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, "Blue", R.drawable.ice_cream_blue))

        dataList.add(IceCreamModel(R.drawable.ice_cream_red, R.drawable.ice_cream_green,R.drawable.ice_cream_blue, R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange, "Red", R.drawable.ice_cream_red))
        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange, R.drawable.ice_cream_red,R.drawable.ice_cream_blue, R.drawable.ice_cream_green, "Red", R.drawable.ice_cream_red))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red,R.drawable.ice_cream_blue, R.drawable.ice_cream_orange, "Red", R.drawable.ice_cream_red))

        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange,R.drawable.ice_cream_red, R.drawable.ice_cream_brown, "Green", R.drawable.ice_cream_green))
        dataList.add(IceCreamModel(R.drawable.ice_cream_brown, R.drawable.ice_cream_orange, R.drawable.ice_cream_red, R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, "Green", R.drawable.ice_cream_green))
        dataList.add(IceCreamModel(R.drawable.ice_cream_orange,R.drawable.ice_cream_brown, R.drawable.ice_cream_yellow, R.drawable.ice_cream_red, R.drawable.ice_cream_green, "Green", R.drawable.ice_cream_green))

        dataList.add(IceCreamModel(R.drawable.ice_cream_yellow, R.drawable.ice_cream_orange,R.drawable.ice_cream_red, R.drawable.ice_cream_blue, R.drawable.ice_cream_green, "Yellow", R.drawable.ice_cream_yellow))
        dataList.add(IceCreamModel(R.drawable.ice_cream_green, R.drawable.ice_cream_yellow, R.drawable.ice_cream_blue, R.drawable.ice_cream_red,R.drawable.ice_cream_orange, "Yellow", R.drawable.ice_cream_yellow))
        dataList.add(IceCreamModel(R.drawable.ice_cream_blue, R.drawable.ice_cream_orange, R.drawable.ice_cream_green,R.drawable.ice_cream_red, R.drawable.ice_cream_yellow, "Yellow", R.drawable.ice_cream_yellow))
    }


    fun gameList(): MutableList<IceCreamModel> {
        if (levelState < 10)
            gameList0()
        else if (levelState < 20)
            gameList1()
        else if (levelState < 30)
            gameList2()
        else if (levelState < 40)
            gameList3()
        else {
            gameList4()
            n = 2
        }

        gameData.add(dataList[rand.nextInt(3 * n)])
        gameData.add(dataList[rand.nextInt((6 - 3) * n) + 3 * n])
        gameData.add(dataList[rand.nextInt((9 - 6) * n) + 6 * n])


        return gameData
    }
}

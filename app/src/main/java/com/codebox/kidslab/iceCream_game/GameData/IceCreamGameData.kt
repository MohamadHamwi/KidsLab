package com.codebox.kidslab.iceCream_game.GameData

import com.codebox.kidslab.Progress.DataFactory
import com.codebox.kidslab.R
import java.util.*


class IceCreamGameData {
    private val dataList: MutableList<IceCreamModel> = mutableListOf<IceCreamModel>()
    private var rand = Random()
    var gameData = mutableListOf<IceCreamModel>()
    private val LEVEL_KEY = "Level"
    private val dataStorage = DataFactory.instance
    val levelState = dataStorage.getDouble(LEVEL_KEY)

    var n = 1

    var color1: Int = 0
    var color2: Int = 0
    var color3: Int = 0
    var color4: Int = 0
    var color5: Int = 0
    var color6: Int = 0


    init {
        if (levelState < 50) {
            color1 = R.drawable.ice_cream_red
            color2 = R.drawable.ice_cream_green
            color3 = R.drawable.ice_cream_yellow
            color4 = R.drawable.ice_cream_blue
            color5 = R.drawable.ice_cream_orange
            color6 = R.drawable.ice_cream_brown


        }
    }

    private fun gameList0() {
        dataList.add(IceCreamModel(color1, color2, color3, null, null, "Red", color1))
        dataList.add(IceCreamModel(color3, color1, color2, null, null, "Red", color1))
        dataList.add(IceCreamModel(color2, color3, color1, null, null, "Red", color1))

        dataList.add(IceCreamModel(color2, color3, color1, null, null, "Green", color2))
        dataList.add(IceCreamModel(color1, color2, color3, null, null, "Green", color2))
        dataList.add(IceCreamModel(color3, color1, color2, null, null, "Green", color2))

        dataList.add(IceCreamModel(color3, color1, color2, null, null, "Yellow", color3))
        dataList.add(IceCreamModel(color2, color3, color1, null, null, "Yellow", color3))
        dataList.add(IceCreamModel(color1, color2, color3, null, null, "Yellow", color3))
    }

    private fun gameList1() {
        dataList.add(IceCreamModel(color4, color2, color3, null, null, "Blue", color4))
        dataList.add(IceCreamModel(color3, color4, color2, null, null, "Blue", color4))
        dataList.add(IceCreamModel(color2, color3, color4, null, null, "Blue", color4))

        dataList.add(IceCreamModel(color2, color3, color4, color1, null, "Red", color1))
        dataList.add(IceCreamModel(color4, color2, color1, color3, null, "Green", color2))
        dataList.add(IceCreamModel(color1, color3, color4, color2, null, "Green", color2))

        dataList.add(IceCreamModel(color3, color4, color2, null, null, "Yellow", color3))
        dataList.add(IceCreamModel(color2, color3, color4, null, null, "Yellow", color3))
        dataList.add(IceCreamModel(color4, color2, color3, null, null, "Yellow", color3))
    }

    private fun gameList2() {
        dataList.add(IceCreamModel(color5, color2, color3, null, null, "Orange", color5))
        dataList.add(IceCreamModel(color4, color5, color2, null, null, "Orange", color5))
        dataList.add(IceCreamModel(color2, color4, color5, null, null, "Orange", color5))

        dataList.add(IceCreamModel(color2, color5, color4, color1, color3, "Green", color2))
        dataList.add(IceCreamModel(color4, color2, color3, color5, color1, "Red", color1))
        dataList.add(IceCreamModel(color1, color5, color3, color2, color4, "Red", color1))

        dataList.add(IceCreamModel(color4, color1, color5, color2, color3, "Blue", color4))
        dataList.add(IceCreamModel(color2, color1, color3, color5, color4, "Yellow", color3))
        dataList.add(IceCreamModel(color5, color2, color3, color1, color4, "Blue", color4))

    }

    private fun gameList3() {
        dataList.add(IceCreamModel(color6, color2, color1, null, null, "brown", color6))
        dataList.add(IceCreamModel(color3, color5, color6, color2, null, "brown", color6))
        dataList.add(IceCreamModel(color4, color6, color1, color3, null, "brown", color6))

        dataList.add(IceCreamModel(color5, color3, color4, color2, color1, "Orange", color5))
        dataList.add(IceCreamModel(color4, color2, color3, color1, color5, "Green", color2))
        dataList.add(IceCreamModel(color1, color5, color4, color2, color6, "Orange", color5))

        dataList.add(IceCreamModel(color2, color1, color6, color3, color5, "Red", color1))
        dataList.add(IceCreamModel(color3, color5, color1, color4, color2, "Blue", color4))
        dataList.add(IceCreamModel(color4, color2, color6, color3, color1, "Blue", color4))
    }

    private fun gameList4() {
        dataList.add(IceCreamModel(color6, color4, color2, color3, color1, "brown", color6))
        dataList.add(IceCreamModel(color3, color1, color5, color6, color2, "brown", color6))
        dataList.add(IceCreamModel(color2, color3, color4, color1, color6, "brown", color6))

        dataList.add(IceCreamModel(color5, color6, color2, color3, color4, "Orange", color5))
        dataList.add(IceCreamModel(color3, color6, color4, color5, color2, "Orange", color5))
        dataList.add(IceCreamModel(color2, color3, color4, color6, color5, "Orange", color5))

        dataList.add(IceCreamModel(color6, color2, color3, color4, color5, "Blue", color4))
        dataList.add(IceCreamModel(color3, color4, color5, color6, color2, "Blue", color4))
        dataList.add(IceCreamModel(color5, color2, color6, color3, color4, "Blue", color4))

        dataList.add(IceCreamModel(color1, color2, color4, color3, color5, "Red", color1))
        dataList.add(IceCreamModel(color3, color5, color1, color4, color2, "Red", color1))
        dataList.add(IceCreamModel(color2, color3, color1, color4, color5, "Red", color1))

        dataList.add(IceCreamModel(color2, color3, color5, color1, color6, "Green", color2))
        dataList.add(IceCreamModel(color6, color5, color1, color2, color3, "Green", color2))
        dataList.add(IceCreamModel(color5, color6, color3, color1, color2, "Green", color2))

        dataList.add(IceCreamModel(color3, color5, color1, color4, color2, "Yellow", color3))
        dataList.add(IceCreamModel(color2, color3, color4, color1, color5, "Yellow", color3))
        dataList.add(IceCreamModel(color4, color5, color2, color1, color3, "Yellow", color3))
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

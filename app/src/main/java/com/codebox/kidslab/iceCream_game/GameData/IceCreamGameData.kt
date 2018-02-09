package com.codebox.kidslab.iceCream_game.GameData

import android.content.Context
import com.codebox.kidslab.Progress.DataFactory
import com.codebox.kidslab.R
import java.util.*


class IceCreamGameData(context: Context) {
    private val dataList: MutableList<IceCreamModel> = mutableListOf<IceCreamModel>()
    private var rand = Random()
    var gameData = mutableListOf<IceCreamModel>()
    private val LEVEL_KEY = "Level"
    private val dataStorage = DataFactory.instance
    val levelState = dataStorage.getDouble(LEVEL_KEY)

    var n = 1

    var color1: Int
    var color2: Int
    var color3: Int
    var color4: Int
    var color5: Int
    var color6: Int

    var txtColor1: String
    var txtColor2: String
    var txtColor3: String
    var txtColor4: String
    var txtColor5: String
    var txtColor6: String
    var isColorGroup2 = false

    init {
        if (levelState < 50) {
            color1 = R.drawable.ice_cream_red
            txtColor1 = context.getString(R.string.color_red)
            color2 = R.drawable.ice_cream_green
            txtColor2 = context.getString(R.string.color_green)
            color3 = R.drawable.ice_cream_yellow
            txtColor3 = context.getString(R.string.color_yellow)
            color4 = R.drawable.ice_cream_blue
            txtColor4 = context.getString(R.string.color_blue)
            color5 = R.drawable.ice_cream_orange
            txtColor5 = context.getString(R.string.color_orange)
            color6 = R.drawable.ice_cream_brown
            txtColor6 = context.getString(R.string.color_brown)
        } else {
            color1 = R.drawable.ice_cream_pink
            txtColor1 = context.getString(R.string.color_pink)
            color2 = R.drawable.ice_cream_lime
            txtColor2 = context.getString(R.string.color_lime)
            color3 = R.drawable.ice_cream_cyan
            txtColor3 = context.getString(R.string.color_cyan)
            color4 = R.drawable.ice_cream_purple
            txtColor4 = context.getString(R.string.color_purple)
            color5 = R.drawable.ice_cream_gray
            txtColor5 = context.getString(R.string.color_gray)
            color6 = R.drawable.ice_cream_white
            txtColor6 = context.getString(R.string.color_white)

            isColorGroup2 = true
        }
    }

    private fun gameList0() {
        dataList.add(IceCreamModel(color1, color2, color3, null, null, txtColor1, color1))
        dataList.add(IceCreamModel(color3, color1, color2, null, null, txtColor1, color1))
        dataList.add(IceCreamModel(color2, color3, color1, null, null, txtColor1, color1))

        dataList.add(IceCreamModel(color2, color3, color1, null, null, txtColor2, color2))
        dataList.add(IceCreamModel(color1, color2, color3, null, null, txtColor2, color2))
        dataList.add(IceCreamModel(color3, color1, color2, null, null, txtColor2, color2))

        dataList.add(IceCreamModel(color3, color1, color2, null, null, txtColor3, color3))
        dataList.add(IceCreamModel(color2, color3, color1, null, null, txtColor3, color3))
        dataList.add(IceCreamModel(color1, color2, color3, null, null, txtColor3, color3))
    }

    private fun gameList1() {
        dataList.add(IceCreamModel(color4, color2, color3, null, null, txtColor4, color4))
        dataList.add(IceCreamModel(color3, color4, color2, null, null, txtColor4, color4))
        dataList.add(IceCreamModel(color2, color3, color4, null, null, txtColor4, color4))

        dataList.add(IceCreamModel(color2, color3, color4, color1, null, txtColor1, color1))
        dataList.add(IceCreamModel(color4, color2, color1, color3, null, txtColor2, color2))
        dataList.add(IceCreamModel(color1, color3, color4, color2, null, txtColor2, color2))

        dataList.add(IceCreamModel(color3, color4, color2, null, null, txtColor3, color3))
        dataList.add(IceCreamModel(color2, color3, color4, null, null, txtColor3, color3))
        dataList.add(IceCreamModel(color4, color2, color3, null, null, txtColor3, color3))
    }

    private fun gameList2() {
        dataList.add(IceCreamModel(color5, color2, color3, null, null, txtColor5, color5))
        dataList.add(IceCreamModel(color4, color5, color2, null, null, txtColor5, color5))
        dataList.add(IceCreamModel(color2, color4, color5, null, null, txtColor5, color5))

        dataList.add(IceCreamModel(color2, color5, color4, color1, color3, txtColor2, color2))
        dataList.add(IceCreamModel(color4, color2, color3, color5, color1, txtColor1, color1))
        dataList.add(IceCreamModel(color1, color5, color3, color2, color4, txtColor1, color1))

        dataList.add(IceCreamModel(color4, color1, color5, color2, color3, txtColor4, color4))
        dataList.add(IceCreamModel(color2, color1, color3, color5, color4, txtColor3, color3))
        dataList.add(IceCreamModel(color5, color2, color3, color1, color4, txtColor4, color4))

    }

    private fun gameList3() {
        dataList.add(IceCreamModel(color6, color2, color1, null, null, txtColor6, color6))
        dataList.add(IceCreamModel(color3, color5, color6, color2, null, txtColor6, color6))
        dataList.add(IceCreamModel(color4, color6, color1, color3, null, txtColor6, color6))

        dataList.add(IceCreamModel(color5, color3, color4, color2, color1, txtColor5, color5))
        dataList.add(IceCreamModel(color4, color2, color3, color1, color5, txtColor2, color2))
        dataList.add(IceCreamModel(color1, color5, color4, color2, color6, txtColor5, color5))

        dataList.add(IceCreamModel(color2, color1, color6, color3, color5, txtColor1, color1))
        dataList.add(IceCreamModel(color3, color5, color1, color4, color2, txtColor4, color4))
        dataList.add(IceCreamModel(color4, color2, color6, color3, color1, txtColor4, color4))
    }

    private fun gameList4() {
        dataList.add(IceCreamModel(color6, color4, color2, color3, color1, txtColor6, color6))
        dataList.add(IceCreamModel(color3, color1, color5, color6, color2, txtColor6, color6))
        dataList.add(IceCreamModel(color2, color3, color4, color1, color6, txtColor6, color6))

        dataList.add(IceCreamModel(color5, color6, color2, color3, color4, txtColor5, color5))
        dataList.add(IceCreamModel(color3, color6, color4, color5, color2, txtColor5, color5))
        dataList.add(IceCreamModel(color2, color3, color4, color6, color5, txtColor5, color5))

        dataList.add(IceCreamModel(color6, color2, color3, color4, color5, txtColor4, color4))
        dataList.add(IceCreamModel(color3, color4, color5, color6, color2, txtColor4, color4))
        dataList.add(IceCreamModel(color5, color2, color6, color3, color4, txtColor4, color4))

        dataList.add(IceCreamModel(color1, color2, color4, color3, color5, txtColor1, color1))
        dataList.add(IceCreamModel(color3, color5, color1, color4, color2, txtColor1, color1))
        dataList.add(IceCreamModel(color2, color3, color1, color4, color5, txtColor1, color1))

        dataList.add(IceCreamModel(color2, color3, color5, color1, color6, txtColor2, color2))
        dataList.add(IceCreamModel(color6, color5, color1, color2, color3, txtColor2, color2))
        dataList.add(IceCreamModel(color5, color6, color3, color1, color2, txtColor2, color2))

        dataList.add(IceCreamModel(color3, color5, color1, color4, color2, txtColor3, color3))
        dataList.add(IceCreamModel(color2, color3, color4, color1, color5, txtColor3, color3))
        dataList.add(IceCreamModel(color4, color5, color2, color1, color3, txtColor3, color3))
    }


    fun gameList(): MutableList<IceCreamModel> {
        if (levelState < 10 || (levelState > 50 && levelState <= 59 && isColorGroup2))
            gameList0()
        else if (levelState < 20 || (levelState < 60 && isColorGroup2))
            gameList1()
        else if (levelState < 30 || (levelState < 70 && isColorGroup2))
            gameList2()
        else if (levelState < 40 || (levelState < 80 && isColorGroup2))
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

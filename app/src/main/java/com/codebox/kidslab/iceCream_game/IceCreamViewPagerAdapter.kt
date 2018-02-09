package com.codebox.kidslab.iceCream_game

import android.content.Context
import android.graphics.PixelFormat
import android.os.Handler
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.codebox.kidslab.Progress.DataFactory
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.Helper
import com.codebox.kidslab.framework.MagicTextView
import com.codebox.kidslab.framework.inflater
import com.codebox.kidslab.iceCream_game.DrawIceCream.IceCreamDraw
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.blueCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.brownCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.cyanCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.grayCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.greenCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.limeCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.orangeCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.pinkCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.purpleCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.redCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.whiteCream
import com.codebox.kidslab.iceCream_game.GameData.CreamsDrawables.yellowCream
import com.codebox.kidslab.iceCream_game.GameData.IceCreamGameData
import com.codebox.kidslab.iceCream_game.GameData.SoundPlayer


/**
 * Created by Abed on 10/2/2017.
 */
class IceCreamViewPagerAdapter(val mContext: Context) : PagerAdapter(), View.OnClickListener {


    private val dataIceCreamModel = IceCreamGameData(mContext).gameList()
    private var isMedium = mutableListOf<Boolean>(false, false, false)
    private var isHard = mutableListOf<Boolean>(false, false, false)
    private var lose = 0
    private val soundPlayer = SoundPlayer(mContext)
    private var isLevel2 = true
    private var isClickedOK = false
    private var LEVEL_KEY = "Level"
    private var SCORE_KEY = "Score"
    private val saveState = DataFactory.instance
    private var score: Double = 0.0
    private val levelState: Double = saveState.getDouble(LEVEL_KEY)
    private var currentPagePosition = 0
    private val maxPages = 3


    override fun getCount(): Int = dataIceCreamModel.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {

        collection.removeView(view as View)
    }

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {

        if (levelState % 10.0 == 0.0 || levelState % 10.0 == 0.5) {
            saveState.put(SCORE_KEY, 0.0)
        }
        score = saveState.getDouble(SCORE_KEY)
        isLevel2 = score in 2.0..5.5 || score > 8.0 || (levelState > 40 && levelState < 50) || levelState > 90
        val data = dataIceCreamModel[position]
        if (data.img5 != null) {
            isMedium[position] = true
            isHard[position] = true
        } else if (data.img4 != null)
            isMedium[position] = true
        val view = if (isHard[position])
            collection.inflater(R.layout.ice_cream_item_hard)
        else if (isMedium[position])
            collection.inflater(R.layout.ice_cream_item_medium)
        else
            collection.inflater(R.layout.ice_cream_item_easy)

        collection.addView(view)

        val img1: ImageView = view.findViewById(R.id.cream1)
        val img2: ImageView = view.findViewById(R.id.cream2)
        val img3: ImageView = view.findViewById(R.id.cream3)
        val img4: ImageView? = view.findViewById(R.id.cream4)
        val img5: ImageView? = view.findViewById(R.id.cream5)

        img1.init(data.img1)
        img2.init(data.img2)
        img3.init(data.img3)
        img4?.init(data.img4!!)
        img5?.init(data.img5!!)

        val textQuest = view.findViewById<MagicTextView>(R.id.creamQuestion)

        with(textQuest) {
            text = data.textQuest
            setTextColor(getColor(data.textQuest))
        }

        return view
    }

    override fun onClick(v: View) {
        if (currentPagePosition < maxPages) {
            val view = (v.parent as LinearLayout).parent as ConstraintLayout

            val winierCream = dataIceCreamModel[currentPagePosition].winierCream

            val img = view.findViewById<ImageView>(v.id)
            val des = img.contentDescription
            val text = view.findViewById<TextView>(R.id.creamQuestion).text
            if (!isClickedOK) {
                img.visibility = View.INVISIBLE
                if (des == text) {
                    isClickedOK = true
                    putCream(winierCream, view)
                } else {
                    ++lose
                    soundPlayer.wrong()
                }
            }
        }
    }

    private fun putCream(winierCream: Int, parentView: ConstraintLayout) {
        val iceCream = if (isLevel2) ((mContext) as IceCreamActivity).iceCreamDrawMain[currentPagePosition] as IceCreamDraw else parentView.findViewById(R.id.iceCreamDraw)


        iceCream.changeImage(winierCream)

        if (isLevel2) {
            iceCream.creamNum = currentPagePosition
        }
        iceCream.changeImage(winierCream)

        iceCream.setZOrderOnTop(true)
        val sfhTrack = iceCream.holder
        sfhTrack.setFormat(PixelFormat.TRANSLUCENT)

        iceCream.visibility = View.VISIBLE
        currentPagePosition++
        (mContext) as IceCreamActivity

        if ((mContext).isLastPage())
            applyCurrentPlayScore()

        when (winierCream) {
            redCream -> soundPlayer.red()
            greenCream -> soundPlayer.green()
            yellowCream -> soundPlayer.yellow()
            blueCream -> soundPlayer.blue()
            orangeCream -> soundPlayer.orange()
            brownCream -> soundPlayer.brown()
        }
        val delayTime: Long = if (Helper().isTablet(mContext)) 2300 else 2000
        Handler().postDelayed({
            isClickedOK = false

            if (!isLevel2) {
                iceCream.visibility = View.INVISIBLE
            }
        }, delayTime - 50)
        (mContext).drawStars(delayTime)

    }

    private fun ImageView.init(img: Int) {
        background = ContextCompat.getDrawable(mContext, img)
        contentDescription = checkCream(img)
        setOnClickListener(this@IceCreamViewPagerAdapter)
    }

    private fun getColor(textQuest: String): Int {
        return if (score < 6.0 && levelState <= 40 || (levelState > 49 && levelState <= 90)) {
            val color = when (textQuest) {
                mContext.getString(R.string.color_red) -> R.color.Red
                mContext.getString(R.string.color_green) -> R.color.Green
                mContext.getString(R.string.color_yellow) -> R.color.Yellow
                mContext.getString(R.string.color_blue) -> R.color.Blue500
                mContext.getString(R.string.color_orange) -> R.color.Orange
                mContext.getString(R.string.color_brown) -> R.color.Brown900

                mContext.getString(R.string.color_pink) -> R.color.Pink
                mContext.getString(R.string.color_cyan) -> R.color.Cyan
                mContext.getString(R.string.color_lime) -> R.color.Lime
                mContext.getString(R.string.color_gray) -> R.color.Gray
                mContext.getString(R.string.color_purple) -> R.color.Purple
                mContext.getString(R.string.color_white) -> R.color.white

                else -> R.color.Black
            }
            mContext.resources.getColor(color)
        } else mContext.resources.getColor(R.color.Black)
    }

    private fun checkCream(creamImg: Int) = when (creamImg) {
        redCream -> mContext.getString(R.string.color_red)
        greenCream -> mContext.getString(R.string.color_green)
        yellowCream -> mContext.getString(R.string.color_yellow)
        blueCream -> mContext.getString(R.string.color_blue)
        orangeCream -> mContext.getString(R.string.color_orange)
        brownCream -> mContext.getString(R.string.color_brown)

        pinkCream -> mContext.getString(R.string.color_pink)
        cyanCream -> mContext.getString(R.string.color_cyan)
        limeCream -> mContext.getString(R.string.color_lime)
        grayCream -> mContext.getString(R.string.color_gray)
        purpleCream -> mContext.getString(R.string.color_purple)
        whiteCream -> mContext.getString(R.string.color_white)

        else -> null
    }


    private fun applyCurrentPlayScore() {
        val score_old = saveState.getDouble(SCORE_KEY)
        if (lose == 0 && levelState < 100) {
            saveState.put(LEVEL_KEY, levelState + 1.0)
            saveState.put(SCORE_KEY, score_old + 1.0)
        } else if (lose <= 3 && levelState <= 100) {
            saveState.put(LEVEL_KEY, levelState + 0.5)
            saveState.put(SCORE_KEY, score_old + 0.5)

        } else if (lose < 6 && levelState <= -1.0) {
            saveState.put(LEVEL_KEY, levelState - 0.5)
            saveState.put(SCORE_KEY, score_old - 0.5)
        } else {
            if (levelState <= -1.0) {
                saveState.put(LEVEL_KEY, levelState - 1.0)
                saveState.put(SCORE_KEY, score_old - 1.0)
            }
        }
    }
}

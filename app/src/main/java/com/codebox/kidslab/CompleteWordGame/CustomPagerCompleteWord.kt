package com.codebox.kidslab.CompleteWordGame

import android.content.Context
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.codebox.kidslab.R
import com.codebox.kidslab.framework.UIColorHelper


/**
 * Created by Abed on 10/18/2017.
 */
class CustomPagerCompleteWord(val dataModel: MutableList<CompleteWordDataModel>, val mContext: Context) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    lateinit var imgQuest: ImageView
    lateinit var txtQuest: TextView
    lateinit var txtResult: TextView

    lateinit var txtOne: TextView
    lateinit var txtTwo: TextView
    lateinit var txtThree: TextView





    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val data = dataModel[position]
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.complete_word_game_item, container, false) as ViewGroup
        container.addView(view)
        imgQuest = view.findViewById(R.id.imageQuest)
        txtQuest = view.findViewById(R.id.txtQuest)
        txtResult = view.findViewById(R.id.txtQuestResult)

        txtQuest.tag = "Quest"+position

        txtOne = view.findViewById(R.id.charOnetxt)
        txtTwo = view.findViewById(R.id.charTwotxt)
        txtThree = view.findViewById(R.id.charThreetxt)

        imgQuest.background = ContextCompat.getDrawable(mContext, data.imgQuest)
        txtQuest.text = "?"

        txtOne.text = data.charOne.toString()
        txtTwo.text = data.charTwo.toString()
        txtThree.text = data.charThree.toString()

        val currentTextColor = UIColorHelper(mContext).getRandomA700()

        txtQuest.setTextColor(currentTextColor)


        txtOne.setTextColor(currentTextColor)
        txtTwo.setTextColor(currentTextColor)
        txtThree.setTextColor(currentTextColor)

        val coloredTextQuest = getColoredSpanned(" " + data.txtQuest, "#000")

        appendColoredText(txtQuest, coloredTextQuest)



        txtOne.setOnClickListener {
            if (data.charOne.equals(data.winChar)) {
                ((mContext) as CompleteWordActivity).replaceText(data.winChar, data.txtQuest)
                mContext.nextPage()
            }

        }
        txtTwo.setOnClickListener {
            if (data.charTwo.equals(data.winChar)) {
                ((mContext) as CompleteWordActivity).replaceText(data.winChar, data.txtQuest)
                mContext.nextPage()
            }
        }
        txtThree.setOnClickListener {
            if (data.charThree.equals(data.winChar)) {
                ((mContext) as CompleteWordActivity).replaceText(data.winChar, data.txtQuest)
                mContext.nextPage()
            }
        }
        return view
    }


    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int = dataModel.size

    //text coloring
    fun getColoredSpanned(text: String, color: String): String {
        return "<font color=$color>$text</font>"
    }

    fun appendColoredText(txtQuest: TextView, coloredQuest: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtQuest.append(Html.fromHtml(coloredQuest, FROM_HTML_MODE_LEGACY))
        } else {
            txtQuest.append(Html.fromHtml(coloredQuest))
        }
    }

}
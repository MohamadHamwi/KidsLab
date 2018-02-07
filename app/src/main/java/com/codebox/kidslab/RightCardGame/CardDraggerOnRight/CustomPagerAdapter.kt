package com.codebox.kidslab.RightCardGame.CardDraggerOnRight


import android.annotation.SuppressLint
import android.content.Context
import android.os.Build

import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.CardView
import android.view.*
import android.widget.ImageView
import com.codebox.kidslab.R
import com.codebox.kidslab.RightCardGame.TouchListener
import com.codebox.kidslab.framework.UIColorHelper
import com.codebox.kidslab.framework.snackbar


/**
 * Created by CodeBox on 8/13/2017.
 */
class CustomPagerAdapter(val mContext: Context, val dataModel: MutableList<Model>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    override fun getCount(): Int {
        return dataModel.size
    }


    @SuppressLint("NewApi")
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {

        val data = dataModel[position]
        val inflater = LayoutInflater.from(mContext)
        val view: View = inflater.inflate(R.layout.rightcard_layout_item, collection, false) as ViewGroup
        collection.addView(view)


        val imgHelp: ImageView = view.findViewById(R.id.ivhelp)
        val img1: ImageView = view.findViewById(R.id.imageView1)
        val img2: ImageView = view.findViewById(R.id.imageView2)
        val img3: ImageView = view.findViewById(R.id.imageView3)
        val imgMain: ImageView = view.findViewById(R.id.imageViewMain)

        img1.background = ContextCompat.getDrawable(mContext, data.Img1)
        img2.background = ContextCompat.getDrawable(mContext, data.Img2)
        img3.background = ContextCompat.getDrawable(mContext, data.Img3)


        val cardWiener = view.findViewById<CardView>(data.WinierCardID)

        val imgWiener: ImageView = cardWiener.getChildAt(0) as ImageView

        val card1: CardView = view.findViewById(R.id.cardView1)
        val card2: CardView = view.findViewById(R.id.cardView2)
        val card3: CardView = view.findViewById(R.id.cardView3)

        val UIParent = view.findViewById<ConstraintLayout>(R.id.CardDraggerUIParent)
        val UIcolor = UIColorHelper(mContext).getRandomA700()
        UIColorHelper().currentUIColor = UIcolor
        UIParent.setBackgroundColor(UIcolor)

        imgHelp.setOnClickListener {
            CustomToast(data.ToastMessage, imgWiener.background, data.Activity)
            val finalRadius = Math.hypot(cardWiener.width / 2.000, cardWiener.height / 2.000).toFloat()
            //To make an Attention for kids to the right card

               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
               {
                   val anim = ViewAnimationUtils.createCircularReveal(cardWiener, cardWiener.width / 2, cardWiener.height / 2, 0f, finalRadius)
                    cardWiener.setBackgroundColor(mContext.resources.getColor(R.color.white))
                    anim.start()
                }


        }


        card1.setOnTouchListener(TouchListener(mContext))
        card2.setOnTouchListener(TouchListener(mContext))
        card3.setOnTouchListener(TouchListener(mContext))

        val cardMain: CardView = view.findViewById(R.id.CardViewMain)

        cardMain.setOnDragListener(DragListener(data.WinierCardID,data.ImgMain,mContext))

        val wrapper = ContextThemeWrapper(mContext, R.style.DefaultVector)
        val drawable = ResourcesCompat.getDrawable(mContext.resources,data.ImgMain, wrapper.theme)
        imgMain.setImageDrawable(drawable)
        imgMain.tag = "MainCard"
        return view
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }


}

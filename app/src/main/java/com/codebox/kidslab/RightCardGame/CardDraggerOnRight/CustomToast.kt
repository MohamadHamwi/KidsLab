package com.codebox.kidslab.RightCardGame.CardDraggerOnRight

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.codebox.kidslab.R


class CustomToast(message: String, image: Drawable, activity: Activity) {

    init {
        // Inflate toast XML layout
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.toast_layout, activity.findViewById(R.id.toast_layout_root))
        // Fill in the message into the textview

        layout.findViewById<TextView>(R.id.text).text = message
        layout.findViewById<ImageView>(R.id.ivToast).background = image
        Handler().postDelayed({

        }, 2000)

        // Construct the toast, set the view and display
        val toast = Toast(activity)
        with(toast)
        {
            view = layout
            duration = Toast.LENGTH_SHORT
            show()
        }


    }
}

package com.codebox.kidslab.CardConnect

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DrawingShapesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(DrawingGame(this))
    }
}

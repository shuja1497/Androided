package com.shuja1497.atry

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*


import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*

class Main2Activity : AppCompatActivity() {

    private var layList = intArrayOf(R.layout.fragment_first,R.layout.fragment_second)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        viewFlipper.isAutoStart = true

        viewFlipper.setInAnimation(this, R.anim.in_right)
        viewFlipper.setOutAnimation(this,R.anim.out)
        viewFlipper.setFlipInterval(4000)
        viewFlipper.startFlipping()
    }

}

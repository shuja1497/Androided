package com.shuja1497.atry

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.support.v4.view.ViewPager
import java.util.*


class MainActivity : AppCompatActivity(){


    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 500//delay in_right milliseconds before task is to be executed
    val PERIOD_MS: Long = 3000// time in_right milliseconds between successive task executions.
    val NUM_PAGES = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewPager.adapter = MyPagerAdapter(supportFragmentManager)

        val handler = Handler()
        val Update = object:Runnable {
            public override fun run() {
                if (currentPage == 0)
                {
                    viewPager.setCurrentItem(currentPage++, true)
                }
                else if (currentPage == 1){
                    viewPager.setCurrentItem(currentPage--, true)
                }
            }
        }
        timer = Timer() // This will create a new Thread
        timer!!.schedule(object: TimerTask() { // task to be scheduled
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)
    }

    private class MyPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return 2
        }
        override fun getItem(position: Int): Fragment{

            when (position) {
                0 -> return FirstFragment.newInstance("FirstFragment, Instance 1")
                1 -> return SecondFragment.newInstance("SecondFragment, Instance 1")
                else -> return SecondFragment.newInstance("SecondFragment, Instance 1")

            }
        }
    }

}

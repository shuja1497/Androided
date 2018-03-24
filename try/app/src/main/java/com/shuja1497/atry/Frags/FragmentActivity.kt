package com.shuja1497.atry.Frags

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.shuja1497.atry.R

import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        supportFragmentManager.beginTransaction().add(R.id.layout, OneFragment()).commit()
    }

    @SuppressLint("ResourceType")
    fun onClick(v: View?){
        when(v?.id){

            R.id.button_one ->{
                supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.in_right, R.anim.out)
                        .replace(R.id.layout, TwoFragment())
                        .addToBackStack(null)
                        .commit()
            }

            R.id.button_two->{
                supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.in_right, R.anim.out)
                        .replace(R.id.layout, OneFragment())
                        .addToBackStack(null)
                        .commit()
            }
        }
    }
}

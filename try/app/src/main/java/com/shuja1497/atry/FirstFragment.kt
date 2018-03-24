package com.shuja1497.atry


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView




/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater!!.inflate(R.layout.fragment_first, container, false)

        val tv = view.findViewById(R.id.tvFragFirst) as TextView
        tv.text = arguments.getString("msg")

        return view
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String): FirstFragment {
            val f = FirstFragment()
            val b = Bundle()
            b.putString("msg", param1)
            f.arguments = b
            return f
        }
    }
}// Required empty public constructor

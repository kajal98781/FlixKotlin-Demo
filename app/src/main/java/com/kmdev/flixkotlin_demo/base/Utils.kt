package com.kmdev.flixkotlin_demo.base


import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by Kajal_Mittal on 19/05/17.
 */

object Utils {

    fun setFragmentWithoutBackStack(context: Context, viewResourceId: Int, fragment: Fragment, withAnimation: Boolean) {
        val fragmentTransaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(viewResourceId, fragment, fragment.javaClass.simpleName).commit()
    }


}

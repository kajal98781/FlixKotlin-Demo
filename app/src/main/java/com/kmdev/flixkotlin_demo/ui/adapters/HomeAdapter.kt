package com.kmdev.flixKotlinDemo.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


import java.util.ArrayList

/**
 * Created by Kajal_Mittal on 20/05/17.
 */

class HomeAdapter(fm: FragmentManager, fragments: ArrayList<Fragment>, titleList: List<String>) : FragmentStatePagerAdapter(fm) {
    //If you mark it internal, it is visible everywhere in the same module;
    internal var fragments = ArrayList<Fragment>()
    internal var fragmentTitleList: List<String> = ArrayList()

    init {
        this.fragments = fragments
        fragmentTitleList = titleList


    }

    override fun getItem(position: Int): Fragment {

        return fragments[position]

    }


    override fun getCount(): Int {
        return fragments.size
    }


    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }
}

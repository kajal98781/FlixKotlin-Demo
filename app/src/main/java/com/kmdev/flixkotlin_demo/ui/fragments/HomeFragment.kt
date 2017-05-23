package com.kmdev.flixKotlinDemo.ui.fragments

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.support.v4.view.ViewPager
import com.kmdev.flixKotlinDemo.ui.adapters.HomeAdapter
import com.kmdev.flixkotlin_demo.R


/**
 * Created by Kajal_Mittal on 20/05/17.
 */

class HomeFragment : Fragment(), TabLayout.OnTabSelectedListener {

    private var mViewPager: ViewPager? = null
    private var mTabLayout: TabLayout? = null
    private var mListFragments: ArrayList<Fragment>? = null
    //  private var mToolBar: Toolbar? = null
    /*   The Kotlin List<out T> type is an interface that provides read only operations like size, get
       and so on. Like in Java, it inherits from Collection<T>
       and that in turn inherits from Iterable<T>. Methods that change the list
       are added by the MutableList<T> interface.*/
    private var mTitleList: MutableList<String>? = null


    /*If a singleton object shares the same name as that of a class and is defined within the same
    file, the singleton object is called a “companion object” and the class is called a “companion class”.

    First, Kotlin doesn't use the Java concept of static members because Kotlin has its own concept of
    objects for describing properties and functions connected with singleton state, and Java static
    part of a class can be elegantly expressed in terms of singleton:
    it's a singleton object that can be called by the class' name. Hence the naming:
    it's an object that comes with a class.
    */
    companion object {
        fun newInstance(): HomeFragment {

            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home, container, false)
        init(view)
        tabSelection()
        return view
    }

    private fun tabSelection() {
        mTabLayout!!.addTab(mTabLayout!!.newTab().setText(R.string.movies))
        mTabLayout!!.addTab(mTabLayout!!.newTab().setText(R.string.tv_shows))

        mTitleList!!.add(resources.getString(R.string.movies))
        mTitleList!!.add(resources.getString(R.string.tv_shows))

        mTabLayout!!.tabGravity = TabLayout.GRAVITY_FILL
        val moviesFragment = ItemListFragment.Companion.newInstance(ItemListFragment.ARG_MOVIES)
        val tvShowsFragment = ItemListFragment.Companion.newInstance(ItemListFragment.ARG_TV_SHOWS)
        // FavouriteMainFragment favouriteMovieFragment = FavouriteMainFragment.newInstance();

        mListFragments!!.add(moviesFragment)
        mListFragments!!.add(tvShowsFragment)
        // mListFragments.add(favouriteMovieFragment);
        val adapter = HomeAdapter(activity.supportFragmentManager, mListFragments as ArrayList<Fragment>, mTitleList as MutableList<String>)
        mViewPager!!.setAdapter(adapter)
        mTabLayout!!.setupWithViewPager(mViewPager)
        mViewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout?.setOnTabSelectedListener(this)
        mViewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


            }

            override fun onPageScrollStateChanged(state: Int) {
                mViewPager!!.offscreenPageLimit = 2

            }
        })
    }


    private fun init(view: View?) {
        //   mToolBar= view!!.findViewById(R.id.toolbar) as Toolbar
        mViewPager = view?.findViewById(R.id.pager) as ViewPager
        mTabLayout = view!!.findViewById(R.id.tab_layout) as TabLayout
        mListFragments = ArrayList()
        mTitleList = ArrayList()


    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
    }


}

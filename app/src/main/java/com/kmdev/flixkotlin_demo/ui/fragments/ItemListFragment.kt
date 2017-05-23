package com.kmdev.flixKotlinDemo.ui.fragments

import android.icu.util.ValueIterator
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.NavUtils
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView

import com.kmdev.flixKotlinDemo.ui.adapters.MoviesAdapter
import com.kmdev.flixKotlinDemo.ui.models.MoviesModel
import com.kmdev.flixkotlin_demo.R

/**
 * Created by Kajal_Mittal on 20/05/17.
 */

class ItemListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    private var mRecyclerView: RecyclerView? = null;
    private var mMoviesList: MutableList<MoviesModel>? = null

    //one class has only one campanion object
    companion object {
        //these all are static final variables
        val ARG_MOVIES = "movies"
        val ARG_TV_SHOWS = "tv_shows"
        val ARG_TYPE = "type"

        fun newInstance(type: String): ItemListFragment {

            val args = Bundle()
            args.putString(ARG_TYPE, type)
            val fragment = ItemListFragment()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_item_list, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {

        mRecyclerView = view.findViewById(R.id.recycler_view) as RecyclerView

        if (TextUtils.equals(arguments.getString(ARG_TYPE), ARG_MOVIES)) {
            mMoviesList = ArrayList()

            for (i in 1..10) {
                val movies1 = MoviesModel()
                movies1.title = "Movie" + i
                mMoviesList!!.add(movies1)

            }
            mRecyclerView!!.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            mRecyclerView!!.adapter = MoviesAdapter(mMoviesList as ArrayList<MoviesModel>)


        } else {
            val textType = view.findViewById(R.id.tv_type) as TextView
            textType.visibility = View.VISIBLE
            mRecyclerView!!.visibility = View.GONE
            textType.setText(ARG_TV_SHOWS)
        }


    }

    override fun onRefresh() {

    }
}




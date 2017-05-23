package com.kmdev.flixKotlinDemo.ui.adapters

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kmdev.flixKotlinDemo.ui.models.MoviesModel
import com.kmdev.flixkotlin_demo.R
import com.squareup.picasso.Picasso

/**
 * Created by Kajal_Mittal on 22/05/17.
 */
public class MoviesAdapter(mMoviesList:ArrayList<MoviesModel>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private var mViewHolder: ViewHolder? = null
    private  var mPopularList: ArrayList<MoviesModel>?=mMoviesList


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val view= inflater.inflate(R.layout.item_popular_movie, parent, false)
        mViewHolder = ViewHolder(view);
        return mViewHolder as ViewHolder
    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        Picasso.with(holder!!.itemView.context)
                .load(R.mipmap.ic_launcher)
                .error(R.color.color_white)
                .placeholder(R.color.color_white)
                .into(holder.mImageView)

        holder.mTitle.setText(mPopularList!!.get(position).title)



    }

    override fun getItemCount(): Int {
        return mPopularList!!.size

    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
         val mTitle= itemView!!.findViewById(R.id.tv_title) as TextView
        val mImageView=itemView!!.findViewById(R.id.image) as ImageView



    }


}
package com.kmdev.flixKotlinDemo.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.content.Intent
import android.support.design.widget.NavigationView

import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.kmdev.flixKotlinDemo.ui.fragments.HomeFragment
import com.kmdev.flixkotlin_demo.R
import com.kmdev.flixkotlin_demo.base.Utils


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //properties or variables can be declared as mutable, using the var keyword or read-only using the val keyword.
    private var mToolBar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setNavigationDrawer()
        setTitle()

    }

    private fun init() {
        mToolBar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(mToolBar)
        Utils.setFragmentWithoutBackStack(this, R.id.home_fragment, HomeFragment.newInstance(), false)

    }

    private fun setTitle() {
        //!! defines non null,title is set on toolbar if toolbar is not null
        mToolBar!!.setTitle(R.string.app_name)

    }


    private fun setNavigationDrawer() {
        //val is used for read only variables.
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.getItemId()

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_favourite) {

        } else if (id == R.id.nav_settings) {


        } else if (id == R.id.nav_share) {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Take a look at \"Flix\"\nhttps://play.google.com/store/apps/details?id=com.kajalmittal.flix")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)


        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_donate) {

        } else if (id == R.id.nav_people) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
package com.example.listview_homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

lateinit var navController: NavController
class MainActivity : AppCompatActivity(), ListViewFragment.OnListViewInteractionListener {
    //    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val appBar = supportActionBar

//        appBar?.setDisplayHomeAsUpEnabled(true)
        //setupSideNavigationMenu(navController)
        //actionBar.hide()
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }

    override fun onListViewInteraction(movie: MovieData, position: Int, view: View) {
        Log.d("test", "pressed")
        val title = movie.title
        val posterid = posterTable[title]
        val fragment = MovieFragment.newInstance(movieList[position], posterid!!)
        supportFragmentManager.beginTransaction().replace(view.id, fragment).addToBackStack(null).commit()

    }




}


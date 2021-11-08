package com.example.myanimelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.myanimelist.fragment.MainListFragment
import com.example.myanimelist.fragment.MyListFragment
import com.example.myanimelist.fragment.ToWatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main)

        val mainListFragment = MainListFragment()
        val myListFragment = MyListFragment()
        val toWatchFragment = ToWatchFragment()

        makeCurrentFragment(mainListFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.list -> makeCurrentFragment(mainListFragment)
                R.id.my_list -> makeCurrentFragment(myListFragment)
                R.id.to_watch -> makeCurrentFragment(toWatchFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.frame_layout_wrapper, fragment)
        commit()
    }

}
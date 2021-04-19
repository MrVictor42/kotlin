package com.victor.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.victor.spotifyclone.databinding.ActivityMainBinding
import com.victor.spotifyclone.fragments.Home
import com.victor.spotifyclone.fragments.Library
import com.victor.spotifyclone.fragments.Search

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var content: FrameLayout? = null
    private var mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.nav_home -> {
                val homeFragment = Home.newInstance()
                addFragment(homeFragment)
            }
            R.id.nav_search -> {
                val searchFragment = Search.newInstance()
                addFragment(searchFragment)
            }
            R.id.nav_library -> {
                val libraryFragment = Library.newInstance()
                addFragment(libraryFragment)
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        content = binding.content
        binding.bottomMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val homeFragment = Home.newInstance()
        addFragment(homeFragment)
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.content, fragment, fragment.javaClass.simpleName).commit()
    }
}
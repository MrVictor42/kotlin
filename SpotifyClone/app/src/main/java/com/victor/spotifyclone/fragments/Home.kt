package com.victor.spotifyclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.spotifyclone.R

class Home : Fragment() {

    companion object {
        fun newInstance(): Home {
            val fragmentHome = Home()
            val arguments = Bundle()
            fragmentHome.arguments = arguments
            return fragmentHome
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}
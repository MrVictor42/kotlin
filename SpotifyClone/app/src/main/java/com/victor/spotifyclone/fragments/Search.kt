package com.victor.spotifyclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.spotifyclone.R

class Search : Fragment() {

    companion object {
        fun newInstance(): Search {
            val fragmentSearch = Search()
            val arguments = Bundle()
            fragmentSearch.arguments = arguments
            return fragmentSearch
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}
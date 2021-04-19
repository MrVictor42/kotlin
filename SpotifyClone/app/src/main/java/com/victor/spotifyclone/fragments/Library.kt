package com.victor.spotifyclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.spotifyclone.R

class Library : Fragment() {

    companion object {
        fun newInstance(): Library {
            val fragmentLibrary = Library()
            val arguments = Bundle()
            fragmentLibrary.arguments = arguments
            return fragmentLibrary
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library, container, false)
    }
}
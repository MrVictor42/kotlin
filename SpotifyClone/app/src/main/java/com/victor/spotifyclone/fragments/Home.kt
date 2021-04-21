package com.victor.spotifyclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.victor.spotifyclone.R
import com.victor.spotifyclone.model.Category
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_category.view.*
import java.util.ArrayList

class Home : Fragment() {

    private lateinit var categoriesAdapter: CategoryAdapter

    companion object {
        fun newInstance(): Home {
            val fragmentHome = Home()
            val arguments = Bundle()
            fragmentHome.arguments = arguments
            return fragmentHome
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val categories: MutableList<Category> = ArrayList()
        for (c in 0..4) {
            val category = Category()
            category.title = "Category $c"
            categories.add(category)
        }

        categoriesAdapter = CategoryAdapter(categories)
        recyclerViewCategories.adapter = categoriesAdapter
        recyclerViewCategories.layoutManager = LinearLayoutManager(context)
    }

    private inner class CategoryAdapter(private val categories: MutableList<Category>) : RecyclerView.Adapter<CategoryHolder>() {

        // responsável pelo layout que será manipulado
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
            return CategoryHolder(layoutInflater.inflate(R.layout.item_category, parent, false))
        }

        // devolve os itens
        override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
            val category = categories[position]
            holder.bind(category)
        }

        // devolve a posição dos itens
        override fun getItemCount(): Int {
            return categories.size
        }
    }

    private inner class CategoryHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            itemView.text_title.text = category.title
        }
    }
}
package com.victor.onlinestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import com.victor.onlinestore.R
import com.victor.onlinestore.model.Data
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_products.*
import kotlinx.android.synthetic.main.products_list.view.*
import java.text.FieldPosition

class Products : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
//    }

    private lateinit var Adapter: GroupAdapter<ViewHolder>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Adapter = GroupAdapter()
        recycler_products.adapter = Adapter

        findProducts()
    }

    private inner class ProductsItem(internal val adProducts: Data): Item<ViewHolder>() {
        override fun getLayout(): Int {
            return R.layout.products_list
        }

        override fun bind(viewHolder: ViewHolder, position: Int) {
            // pegando os dados do modelo de dados (data) e adicionando na product list
            viewHolder.itemView.name_product.text = adProducts.name
            viewHolder.itemView.price_product.text = adProducts.price
            Picasso.get().load(adProducts.uid).into(viewHolder.itemView.photo_product)
        }
    }

    private fun findProducts() {
        FirebaseFirestore.getInstance().collection("Products")
            .addSnapshotListener {
                snapshot, exception -> exception?.let {
                    return@addSnapshotListener
                }
                snapshot?.let {
                    for(doc in snapshot) {
                        val products = doc.toObject(Data::class.java)
                        Adapter.add(ProductsItem(products))
                    }
                }
            }
    }
}
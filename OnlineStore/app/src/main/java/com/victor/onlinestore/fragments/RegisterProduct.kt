package com.victor.onlinestore.fragments

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.victor.onlinestore.R
import com.victor.onlinestore.databinding.ActivityRegisterProductBinding
import com.victor.onlinestore.model.Data
import java.util.*

class RegisterProduct : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterProductBinding
    private var selectedURI: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSelectPhoto.setOnClickListener {
            selectPhotoFromGallery()
        }

        binding.btnRegisterProduct.setOnClickListener {
            saveInFirebase()
        }
    }

    private fun saveInFirebase() {
        val file = UUID.randomUUID().toString()
        val reference = FirebaseStorage.getInstance().getReference("/images/${file}")
        selectedURI?.let {
            reference.putFile(it).addOnSuccessListener {
                reference.downloadUrl.addOnSuccessListener {
                    val url = it.toString()
                    val name = binding.editNameProduct.text.toString()
                    val price = "R$ " + binding.editPrice.text.toString()
                    val uid = FirebaseAuth.getInstance().uid
                    val Products = Data(url, name, price)
                    //cria uma coleção de produtos no caso
                    FirebaseFirestore.getInstance().collection("Products")
                    .add(Products).addOnSuccessListener {
                        Toast.makeText(this, "Product Registration Successful", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {

                    }
                }
            }
        }
    }

    private fun selectPhotoFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 0) {
            selectedURI = data?.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedURI)
            binding.productPhoto.setImageBitmap(bitmap)
            binding.btnSelectPhoto.alpha = 0f
        }
    }
}
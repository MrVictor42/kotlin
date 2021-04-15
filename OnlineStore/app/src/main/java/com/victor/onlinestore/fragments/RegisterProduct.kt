package com.victor.onlinestore.fragments

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.victor.onlinestore.R
import com.victor.onlinestore.databinding.ActivityRegisterProductBinding

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
package com.example.btgk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.btgk.data.Contact
import com.example.btgk.data.ContactRepository
import com.example.btgk.databinding.ActivityAddNewBinding


class AddNewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewBinding
    private lateinit var res: ContactRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = ContactRepository(application)
        binding.btnAdd.setOnClickListener {
            addContact()
        }


    }

    private fun addContact() {
        val name = binding.edtName.text.toString()
        val phone = binding.edtPhone.text.toString()
        val email = binding.edtEmail.text.toString()
        val contact = Contact(name, phone, email)
        res.insert(contact)
        Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
    }


}
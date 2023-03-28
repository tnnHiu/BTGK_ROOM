package com.example.btgk.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.btgk.R
import com.example.btgk.data.Contact
import com.example.btgk.databinding.ListContactItemBinding

class ContactListAdapter(
    private val context: Context,
    private val contactList: ArrayList<Contact>
) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListContactItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ListContactItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modal: Contact = contactList[position]
        val hBinding = holder.binding
        hBinding.tvName.text = "Name: ${modal.name}"
        hBinding.tvPhone.text = "Name: ${modal.phone}"
        hBinding.tvEmail.text = "Name: ${modal.email}"
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}
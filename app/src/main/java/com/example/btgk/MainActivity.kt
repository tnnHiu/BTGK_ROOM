package com.example.btgk


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btgk.adapter.ContactListAdapter
import com.example.btgk.data.Contact
import com.example.btgk.data.ContactDAO
import com.example.btgk.data.ContactRepository
import com.example.btgk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var res: ContactRepository
    private lateinit var adapter: ContactListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = ContactRepository(application)
        val data: List<Contact> = res.getAll() as List<Contact>
        val contactArrayList: ArrayList<Contact> = ArrayList()

        for (i in data.indices) {
            val name: String = data[i].name
            val phone: String = data[i].phone
            val email: String = data[i].email
            contactArrayList.add(Contact(name, phone, email))

            val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            binding.listContact.layoutManager = linearLayoutManager
            binding.listContact.adapter = ContactListAdapter(this, contactArrayList)


        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this@MainActivity, AddNewActivity::class.java))
        return super.onOptionsItemSelected(item)
    }
}
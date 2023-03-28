package com.example.btgk.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ContactDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getAllContact(): List<Contact>
}
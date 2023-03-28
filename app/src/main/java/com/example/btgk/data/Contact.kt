package com.example.btgk.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contact")
data class Contact(var name: String, var phone: String, var email: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}


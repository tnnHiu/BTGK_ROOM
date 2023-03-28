package com.example.btgk.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDAO(): ContactDAO

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

//        @OptIn(InternalCoroutinesApi::class)
@OptIn(InternalCoroutinesApi::class)
fun getInstance(context: Context): ContactDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                   ContactDatabase::class.java, "contact_database"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                    .also { INSTANCE = it }
            }
            }
        }
    }

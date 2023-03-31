package com.example.btgk.data

import android.app.Application


class ContactRepository(private var application: Application) {
    private var db: ContactDatabase = ContactDatabase.getInstance(application)

    fun insert(contact: Contact?) {
        if (contact != null) {
            db.contactDAO().addContact(contact)
        }
    }

    fun getAll(): List<Contact> {
        return db.contactDAO().getAllContact()
    }

}
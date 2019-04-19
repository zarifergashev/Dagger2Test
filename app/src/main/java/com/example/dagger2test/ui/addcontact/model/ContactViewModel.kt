package com.example.dagger2test.ui.addcontact.model

import android.arch.lifecycle.ViewModel
import com.example.dagger2test.db.entity.ContactEntity

class ContactViewModel(private val contactReposetory: ContactReposetory) : ViewModel() {
    fun addContact(contactEntity: ContactEntity) {
        contactReposetory.addContact(contactEntity)
    }

    fun updateContact(contactEntity: ContactEntity) {
        contactReposetory.addContact(contactEntity)
    }

    fun deleteContact(contactEntity: ContactEntity) {
        contactReposetory.deleteContact(contactEntity)
    }

    fun getAllContacts()=contactReposetory.getAllContacts()

}
package com.example.dagger2test.ui.addcontact.model

import com.example.dagger2test.db.dao.ContactDao
import com.example.dagger2test.db.entity.ContactEntity

class ContactReposetory private constructor(private val contactDao: ContactDao) {

    fun addContact(contactEntity: ContactEntity) {
            contactDao.insertContact(contactEntity)
    }

    fun deleteContact(contactEntity: ContactEntity) {
        contactDao.deleteContact(contactEntity)
    }

    fun getAllContacts() = contactDao.getAllContacts()

    companion object {
        @Volatile
        private var instatce: ContactReposetory? = null

        fun getInstance(contactDao: ContactDao) =
            instatce ?: synchronized(this) {
                instatce ?: ContactReposetory(contactDao).also {
                    instatce = it
                }
            }
    }


}
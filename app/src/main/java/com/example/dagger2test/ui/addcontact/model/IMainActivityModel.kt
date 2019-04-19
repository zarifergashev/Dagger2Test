package com.example.dagger2test.ui.addcontact.model

import com.example.dagger2test.db.entity.ContactEntity


interface IMainActivityModel {
    fun addContact(contactEntity: ContactEntity)
}
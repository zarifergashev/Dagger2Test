package com.example.dagger2test.ui.addcontact.peresenter

import com.example.dagger2test.db.entity.ContactEntity
import io.reactivex.Flowable

interface IMainActivityPresenter {
    fun addContact(contactEntity: ContactEntity)
    fun getAllContacts(): Flowable<MutableList<ContactEntity>>
}
package com.example.dagger2test.ui.addcontact.peresenter

import com.example.dagger2test.db.entity.ContactEntity
import com.example.dagger2test.ui.addcontact.model.ContactViewModel
import com.example.dagger2test.ui.addcontact.view.IMainActivityView

class MainActivityPresenterImpl(private val view: IMainActivityView, private val model: ContactViewModel) :
    IMainActivityPresenter {
    override fun getAllContacts() = model.getAllContacts()


    override fun addContact(contact: ContactEntity) {
        if (!contact.userContact.isNullOrEmpty() && !contact.userName.isNullOrEmpty()) {
            model.addContact(contact)
        } else if (contact.userContact.isNullOrEmpty()) {
            view.showToast("user conrtact is null or empty")
        } else if (contact.userName.isNullOrEmpty()) {
            view.showToast("user name is null or empty")
        } else {
            view.showToast("other erorrs")
        }


    }

}
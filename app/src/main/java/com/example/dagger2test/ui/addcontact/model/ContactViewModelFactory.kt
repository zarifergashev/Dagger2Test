package com.example.dagger2test.ui.addcontact.model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ContactViewModelFactory(private val contactReposetory: ContactReposetory) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContactViewModel(contactReposetory) as T
    }

}
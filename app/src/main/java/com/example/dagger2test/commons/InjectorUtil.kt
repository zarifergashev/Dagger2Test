package com.example.dagger2test.commons

import android.content.Context
import com.example.dagger2test.db.MyAppDatabase
import com.example.dagger2test.ui.addcontact.model.ContactReposetory
import com.example.dagger2test.ui.addcontact.model.ContactViewModelFactory

object InjectorUtil {
    fun injectContactViewModelFactoriy(context: Context): ContactViewModelFactory {
        val contactReposetory = ContactReposetory.getInstance(MyAppDatabase.intance(context)!!.getContactDao())
        return ContactViewModelFactory(contactReposetory)
    }
}
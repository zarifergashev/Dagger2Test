package com.example.dagger2test.ui.addcontact.view

import android.arch.lifecycle.LiveData
import android.view.View
import com.example.dagger2test.db.entity.ContactEntity

interface IMainActivityView {
    fun showToast(message: String)

    fun showSnacbar(message: String)

    fun showSnacbar(message: String, clickHelper: View.OnClickListener)

    fun setListItems(data: LiveData<MutableList<ContactEntity>>)

}
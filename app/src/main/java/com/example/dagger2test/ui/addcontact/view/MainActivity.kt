package com.example.dagger2test.ui.addcontact.view

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.dagger2test.R
import com.example.dagger2test.adapters.ContactAdapter
import com.example.dagger2test.commons.InjectorUtil
import com.example.dagger2test.commons.showSnackbar
import com.example.dagger2test.commons.showToastLong
import com.example.dagger2test.db.entity.ContactEntity
import com.example.dagger2test.ui.addcontact.model.ContactViewModel
import com.example.dagger2test.ui.addcontact.peresenter.MainActivityPresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainActivityView {
    private val adapter by lazy {
        ContactAdapter()
    }
    private val model by lazy {
        ViewModelProviders.of(this, InjectorUtil.injectContactViewModelFactoriy(applicationContext))
            .get(ContactViewModel::class.java)
    }
    private val reposetory by lazy {
        MainActivityPresenterImpl(this, model)

    }


    override fun showToast(message: String) {
        this.showToastLong(message)
    }

    override fun showSnacbar(message: String) {
        main_activity_root_view.showSnackbar(message)
    }

    override fun showSnacbar(message: String, clickHelper: View.OnClickListener) {
        main_activity_root_view.showSnackbar(message, clickHelper)
    }


    override fun setListItems(data: LiveData<MutableList<ContactEntity>>) {
        data.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    @SuppressLint("CheckResult")
    private fun init() {
        recyclerView.adapter = adapter
        reposetory.getAllContacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                adapter.submitList(it)
            }

        button.setOnClickListener {
            reposetory.addContact(
                ContactEntity(
                    0,
                    editText2.text.toString(),
                    editText.text.toString(),
                    (System.currentTimeMillis()).toString()
                )
            )
        }

    }
}

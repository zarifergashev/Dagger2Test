package com.example.dagger2test.adapters

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dagger2test.R
import com.example.dagger2test.db.entity.ContactEntity
import kotlinx.android.synthetic.main.contact_list_row.view.*

class ContactAdapter : ListAdapter<ContactEntity, ContactAdapter.ViewHolder>(ContactEntity.DIFF_UTIL) {

    private var inflater: LayoutInflater? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        if (inflater == null) {
            inflater = LayoutInflater.from(p0.context)
        }
        return ViewHolder(inflater!!.inflate(R.layout.contact_list_row, p0, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(contactEntity: ContactEntity) {
            itemView.textView.text = contactEntity.userName
            itemView.textView2.text = contactEntity.userContact
            itemView.textView3.text = contactEntity.date
        }
    }
}
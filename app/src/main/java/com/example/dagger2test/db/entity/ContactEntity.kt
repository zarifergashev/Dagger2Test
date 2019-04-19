package com.example.dagger2test.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.v7.util.DiffUtil


@Entity
data class ContactEntity(
    @PrimaryKey(autoGenerate = true) val contactId: Int,
    val userContact: String?,
    val userName: String?,
    val date: String?
) {
    companion object {
        var DIFF_UTIL: DiffUtil.ItemCallback<ContactEntity> = object : DiffUtil.ItemCallback<ContactEntity>() {
            override fun areItemsTheSame(contactEntity: ContactEntity, t1: ContactEntity): Boolean {
                return contactEntity.userName == t1.userName && contactEntity.userContact == t1.userContact
            }

            override fun areContentsTheSame(contactEntity: ContactEntity, t1: ContactEntity): Boolean {
                return contactEntity.userName == t1.userName && contactEntity.userContact == t1.userContact
            }
        }
    }
}


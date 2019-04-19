package com.example.dagger2test.db.dao

import android.arch.persistence.room.*
import com.example.dagger2test.db.entity.ContactEntity
import io.reactivex.Flowable

@Dao
interface ContactDao {
    @Insert
    fun insertContact(contactEntity: ContactEntity)

    @Update
    fun updateContact(contactEntity: ContactEntity)

    @Delete
    fun deleteContact(contactEntity: ContactEntity)

    @Query("SELECT * FROM ContactEntity ")
    fun getAllContacts(): Flowable<MutableList<ContactEntity>>


    @Query("SELECT * FROM ContactEntity WHERE userName LIKE '%' || :searchtext || '%' ")
    fun searchContact(searchtext: String): Flowable<MutableList<ContactEntity>>

    @Query("SELECT * FROM ContactEntity WHERE contactId == :contactId ")
    fun getItem(contactId: Int): Flowable<MutableList<ContactEntity>>

}
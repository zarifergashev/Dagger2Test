package com.example.dagger2test.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.dagger2test.commons.DATABASE_NAME
import com.example.dagger2test.commons.DATABASE_VERSION_END
import com.example.dagger2test.db.dao.ContactDao
import com.example.dagger2test.db.entity.ContactEntity

@Database(entities = arrayOf(ContactEntity::class), version = DATABASE_VERSION_END)
abstract class MyAppDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: MyAppDatabase? = null

        fun intance(context: Context) = synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, MyAppDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .addMigrations(MagrationUtil.MAGRATION_1_TO_2)
                .build()
        }

    }

    abstract fun getContactDao(): ContactDao
}
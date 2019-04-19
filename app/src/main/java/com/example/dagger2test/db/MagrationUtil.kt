package com.example.dagger2test.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration
import com.example.dagger2test.commons.DATABASE_VERSION_END
import com.example.dagger2test.commons.DATABASE_VERSION_START

class MagrationUtil {
    companion object {
        val MAGRATION_1_TO_2 = object : Migration(DATABASE_VERSION_START, DATABASE_VERSION_END) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(" ALTER TABLE ContactEntity ADD COLUMN date TEXT")
            }
        }

    }


}
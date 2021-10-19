package com.example.skeletaldiagnosis.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Item::class], version = 3)

abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {

        private var INSTANCE: ItemDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): ItemDatabase {

            val MIGRATION_1_2: Migration = object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE Item "
                            + " DROP COLUMN delete_name" + " DROP COLUMN delete_date")
                }
            }

            val MIGRATION_2_3: Migration = object : Migration(2, 3) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE Item "
                            + " ADD COLUMN item_description String")
                }
            }

            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ItemDatabase::class.java, "Item.db")
                        .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}
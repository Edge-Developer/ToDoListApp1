package com.edgedevstudio.todolistapp_1.Database

import android.content.Context
import androidx.room.*

/**
 * Created by Olorunleke Opeyemi on 21/01/2019.
 **/

@Database(entities = arrayOf(TaskEntry::class), version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDAO

    companion object {
        private val DATABASE_NAME = "todolist"
        private var sInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    AppDatabase.DATABASE_NAME
                )
                    .allowMainThreadQueries() //we will remove this in Part 2
                    .build()
            }

            return sInstance!!
        }
    }
}
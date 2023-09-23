package com.example.runningapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Run::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RunningDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDao

//    companion object {
//        private var dbINSTANCE: RunningDatabase? = null

//        fun getAppDb(context: Context): RunningDatabase {
//            if (dbINSTANCE == null) {
//
//                dbINSTANCE = Room.databaseBuilder<RunningDatabase>(
//                    context.applicationContext,
//                    RunningDatabase::class.java,
//                    "baza123"
//                )
//                    .allowMainThreadQueries()
//                    .build()
//
//            }
//            return dbINSTANCE!!
//        }
}

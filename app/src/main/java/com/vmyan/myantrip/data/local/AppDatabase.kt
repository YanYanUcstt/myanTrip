package com.vmyan.myantrip.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vmyan.myantrip.data.entities.Place
import com.vmyan.myantrip.data.entities.PlaceCategory
import com.vmyan.myantrip.data.entities.SubPlaceCategory
import com.vmyan.myantrip.utils.Constants

@Database(entities = [SubPlaceCategory::class, PlaceCategory::class, Place::class], version = Constants.DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun subPlaceCategoryDao(): SubPlaceCategoryDao
    abstract fun placeCategoryDao() : PlaceCategoryDao
    abstract fun placeDao() : PlaceDao

    companion object {
        @Volatile private var instance : AppDatabase? =null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it}}

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, Constants.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

}
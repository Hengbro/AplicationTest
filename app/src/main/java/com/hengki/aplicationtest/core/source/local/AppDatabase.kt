package com.hengki.aplicationtest.core.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hengki.aplicationtest.core.source.local.dao.ProductDao
import com.hengki.aplicationtest.core.source.local.entity.ProductEntity
import com.hengki.aplicationtest.util.Constants

@Database(
    entities = [
        ProductEntity::class,
    ], version = Constants.DB_VERSION, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): ProductDao
}
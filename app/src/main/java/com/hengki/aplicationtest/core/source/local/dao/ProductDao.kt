package com.hengki.aplicationtest.core.source.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.hengki.aplicationtest.core.source.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = REPLACE)
    fun insert(data: ProductEntity)

    @Insert(onConflict = REPLACE)
    fun insert(data: List<ProductEntity>)

    @Delete
    fun delete(data: ProductEntity)

    @Update
    fun update(data: ProductEntity)

    @Query("SELECT * from productentity ORDER BY id ASC")
    fun getAll(): Flow<List<ProductEntity>>

    @Query("DELETE FROM ProductEntity")
    fun deleteAll()
}
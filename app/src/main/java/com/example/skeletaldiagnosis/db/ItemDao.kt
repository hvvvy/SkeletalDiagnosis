package com.example.skeletaldiagnosis.db

import androidx.room.*

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): List<Item>

    @Query("SELECT * FROM item WHERE bone_type_id = 0")
    fun getStrongStraightAll(): List<Item>

    @Query("SELECT * FROM item WHERE bone_type_id = 1")
    fun getStrongWaveAll(): List<Item>

    @Query("SELECT * FROM item WHERE bone_type_id = 2")
    fun getStrongNaturalAll(): List<Item>

    @Query("SELECT * FROM item WHERE weaknesses_bone_type = 0")
    fun getWeaknessStraightAll(): List<Item>

    @Query("SELECT * FROM item WHERE weaknesses_bone_type = 1")
    fun getWeaknessWaveAll(): List<Item>

    @Query("SELECT * FROM item WHERE weaknesses_bone_type = 2")
    fun getWeaknessNaturalAll(): List<Item>

    @Insert
    fun insert(item: Item)

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("delete from item")
    fun deleteAll()
}
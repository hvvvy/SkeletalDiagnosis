package com.example.skeletaldiagnosis.db

import androidx.room.*

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): List<Item>

    @Query("SELECT * FROM item WHERE strong_straight_flg = 1")
    fun getStrongStraightAll(): List<Item>

    @Query("SELECT * FROM item WHERE strong_wave_flg = 1")
    fun getStrongWaveAll(): List<Item>

    @Query("SELECT * FROM item WHERE strong_natural_flg = 1")
    fun getStrongNaturalAll(): List<Item>

    @Query("SELECT * FROM item WHERE weakness_straight_flg = 1")
    fun getWeaknessStraightAll(): List<Item>

    @Query("SELECT * FROM item WHERE weakness_wave_flg = 1")
    fun getWeaknessWaveAll(): List<Item>

    @Query("SELECT * FROM item WHERE weakness_natural_flg = 1")
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
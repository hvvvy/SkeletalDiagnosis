package com.example.skeletaldiagnosis.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(

    @PrimaryKey(autoGenerate = true)    //自動でidが割り振られる主キー
    val item_id: Int,
    val item_name: String,
    val item_image: String,
    val strong_straight_flg: Boolean,
    val weakness_straight_flg: Boolean,
    val strong_wave_flg: Boolean,
    val weakness_wave_flg: Boolean,
    val strong_natural_flg: Boolean,
    val weakness_natural_flg: Boolean,
    val item_category_id: Int,
    val item_description:String,
    val create_name: String,
    val create_date: String,
    val update_name: String,
    val update_date: String,
)
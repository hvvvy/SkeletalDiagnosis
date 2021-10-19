package com.example.skeletaldiagnosis.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity
data class Item(
    //自動でidが割り振られる主キー
    @PrimaryKey(autoGenerate = true)
    val item_id: Int,
    val item_name: String,
    val item_image: String,
    val bone_type_id: Int,
    val weaknesses_bone_type: Int,
    val item_category_id: Int,
    val item_description:String,
    val create_name: String,
    val create_date: String,
    val update_name: String,
    val update_date: String,
    /*val delete_name: String,
    val delete_date: String*/
)

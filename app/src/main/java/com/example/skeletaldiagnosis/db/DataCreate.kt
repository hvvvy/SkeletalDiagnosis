package com.example.skeletaldiagnosis.db

import android.app.Activity
import android.content.Context
import android.util.Log
import java.time.LocalDate

class DataCreate {

    fun ItemDataCreate(context: Context){

        val database = ItemDatabase.getInstance(context)
        val itemDao = database.itemDao()

        if (itemDao.getAll().isEmpty()) {

// 新規Userの作成
            val whiteTsyatsu = Item(0,
                "白Tシャツ",
                "filenobasyo",
                0,
                1,
                1,
                "白いTシャツ",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            val foodBlouson = Item(0,
                "フードブルゾン",
                "filenobasyo",
                1,
                0,
                0,
                "フードなブルゾン",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())

// Userの追加
            itemDao.insert(whiteTsyatsu)
            Log.i("DbInsert", "whitteTsyatsuInsert")
            itemDao.insert(foodBlouson)
            Log.i("DbInsert", "foodBlousonInsert")
        }
        //itemDao.deleteAll()
    }
}


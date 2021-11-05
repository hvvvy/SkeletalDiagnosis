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

            // 新規Itemの作成
            val trenchCoat = Item(0,
                "トレンチコート",
                "trench_coat",
                0,
                1,
                0,
                "コートの素材のハリが肌質とマッチし、着膨れしない。探偵が好んで着る服。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(trenchCoat)

            val jacket = Item(0,
                "ジャケット",
                "jacket",
                0,
                4,
                0,
                "どんなシーンでも大人らしさを演出できる万能アイテム。着るだけで知的に見えるからふしぎ。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(jacket)

            val duffleCoat = Item(0,
                "ダッフルコート",
                "duffle_coat",
                2,
                0,
                0,
                "柔らかい雰囲気を醸し出せる冬アウターの本命枠。色合いによって印象はガラリと変わる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(duffleCoat)

            val foodBlouson = Item(0,
                "フードブルゾン",
                "food_blouson",
                1,
                4,
                0,
                "フード付きでかわいさを演出し、ブルゾン本来の無骨さを中和。\nフードなブルゾン。気分もるんるん。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(foodBlouson)

            val shortBlouson = Item(0,
                "ショートブルゾン",
                "short_blouson",
                2,
                4,
                0,
                "無骨ながらもオシャレ度UP間違いなし。その魅力は35億。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(shortBlouson)

            val vNeckTopps = Item(0,
                "Vネックトップス",
                "v_neck_tops",
                0,
                1,
                1,
                "首回りに余裕があり、厚みのあるボディをスッキリ見せる。\n白いトップス。それはそれは白いトップス。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(vNeckTopps)

            








            val slacks = Item(0,
                "スラックス",
                "slacks",
                0,
                1,
                0,
                "どんなシーンでも大人らしさを演出できる万能アイテム。迷ったらコレ着とけ。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(slacks)


            //これはテストデータ
            val test = Item(0,
                "ススッスス",
                "slacks",
                0,
                1,
                0,
                "テスト",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(test)


        }
        //新しくデータを追加するには、一度下記のdeleteAll()メソッドのコメントを外してアプリを実行し、再度コメントして実行することにより新しくテーブルを作成する
        //開発段階でのみ使用。リリース時には完全なItemテーブルを作成している予定なので、このメソッドは最後に削除する
        //itemDao.deleteAll()
    }
}


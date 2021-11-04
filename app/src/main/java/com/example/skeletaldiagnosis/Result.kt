package com.example.skeletaldiagnosis

import android.app.AlertDialog
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.example.skeletaldiagnosis.db.Item
import com.example.skeletaldiagnosis.db.ItemDatabase


class Result : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //DBに接続する処理
        val database = ItemDatabase.getInstance(requireActivity())
        val itemDao = database.itemDao()
        // User一覧の取得
        val itemList = itemDao.getAll()


        //Log.i("Db", "$ItemList")


        when (User.userBoneType) {
            //骨格タイプがストレートだった場合の結果画面に表示するテキストや画像
            0 -> {
                val resultText = view.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ストレート")
                resultText.text = boneTypeText

                createResultScreen(User.userBoneType)

                //得意アイテムに張り替える処理
                //ここら辺は省略するためにメソッドで対応？
                /*view.findViewById<ImageView>(R.id.strongItem01)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongItem02)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongItem03)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongItem04)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongItem05)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongItem06)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongItem07)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongItem08)
                    .setImageResource(R.drawable.white_t_shirt)

                 */

                //苦手アイテムに張り替える処理
                view.findViewById<ImageView>(R.id.weaknessItem01)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessItem02)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessItem03)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessItem04)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessItem05)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessItem06)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessItem07)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessItem08)
                    .setImageResource(R.drawable.white_t_shirt)
                //得意素材に張り替える処理
                view.findViewById<ImageView>(R.id.strongMaterial01)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongMaterial02)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongMaterial03)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongMaterial04)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongMaterial05)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongMaterial06)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongMaterial07)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongMaterial08)
                    .setImageResource(R.drawable.white_t_shirt)
                //苦手素材に張り替える処理
                view.findViewById<ImageView>(R.id.weaknessMaterial01)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessMaterial02)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessMaterial03)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessMaterial04)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessMaterial05)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessMaterial06)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessMaterial07)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.weaknessMaterial08)
                    .setImageResource(R.drawable.white_t_shirt)
                //得意柄に張り替える処理
                view.findViewById<ImageView>(R.id.strongPattern01)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongPattern02)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongPattern03)
                    .setImageResource(R.drawable.white_t_shirt)
                view.findViewById<ImageView>(R.id.strongPattern04)
                    .setImageResource(R.drawable.white_t_shirt)


            }
            //骨格タイプがウェーブだった場合の結果画面に表示するテキストや画像
            1 -> {
                val resultText = view.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ウェーブ")
                resultText.text = boneTypeText

                /*view.findViewById<ImageView>(R.id.strongItem01)
                    .setImageResource(R.drawable.food_blouson)*/
            }
            //骨格タイプがナチュラルだった場合の結果画面に表示するテキストや画像
            2 -> {
                val resultText = view.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ナチュラル")
                resultText.text = boneTypeText
            }
        }

        view.findViewById<Button>(R.id.toHomeButton).setOnClickListener {
            findNavController().navigate(R.id.action_Result_to_Home)
        }

        view.findViewById<Button>(R.id.toRecommendOutfitButton).setOnClickListener {
            val action = ResultDirections.actionResultToRecommendOutfit(1)
            findNavController().navigate(action)
        }
    }


    private fun scaleUpImage(image: ImageView, name: String, description: String) {
        // レイアウトオブジェクトから拡大対象のImageViewを取得
        // 拡大対象のImageViewにタップ時のリスナーをセット
        image.setOnClickListener {
            //SubsamplingScaleImageViewのライブラリをbuild.gradle(モジュール)で別途インストールする操作が必要
            val imageViewEnlarged = SubsamplingScaleImageView(requireContext())
            val bitmap = (image.drawable as BitmapDrawable).bitmap
            imageViewEnlarged.setImage(ImageSource.bitmap(bitmap))

            val builder = AlertDialog.Builder(activity)

            builder.setView(imageViewEnlarged)
            //タイトルはDBから取得
            builder.setTitle(name)
            //説明文はDBから取得
            builder.setMessage(description)
            builder.setNegativeButton("閉じる", null)
            builder.show()


        }
    }


    private fun createResultScreen(judgeBoneTypeNum: Int) {
        //丸々要らんかも・・・
        /*//DBに接続する処理
        val database = ItemDatabase.getInstance(requireActivity())
        val itemDao = database.itemDao()

        val strongFashionComponentList = when(judgeBoneTypeNum){
        //item_bone_typeが0（ストレートタイプ）のアイテムを抽出
            0 -> itemDao.getStrongStraightAll()
            1 -> itemDao.getStrongWaveAll()
            2 -> itemDao.getStrongNaturalAll()
            //ダミー
            else -> itemDao.getStrongNaturalAll()
        }*/


        //ここにコメントアウトしたwhen式使えるかも
        val strongItemResource = listOf(R.drawable.white_t_shirt,
            R.drawable.white_t_shirt,
            R.drawable.white_t_shirt,
            R.drawable.white_t_shirt,
            R.drawable.white_t_shirt,
            R.drawable.white_t_shirt,
            R.drawable.white_t_shirt)

/*
        val layout = LinearLayout(context)

        // 垂直方向にレイアウト内のパーツを並べる設定とする
        layout.orientation = LinearLayout.VERTICAL
        // レイアウトの縦横サイズをMATCH_PARENTにする
        layout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
        )
        // レイアウト中央寄せ
        layout.gravity = Gravity.CENTER
        // setContentViewにlayoutを設定
        requireActivity().setContentView(layout)



        val layout1 = LinearLayout(context)
        // 垂直方向にレイアウト内のパーツを並べる設定とする
        layout1.orientation = LinearLayout.HORIZONTAL
        // レイアウトの縦横サイズをMATCH_PARENTにする
        layout1.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
        )
        // レイアウト中央寄せ
        layout1.gravity = Gravity.CENTER;
        // setContentViewにlayoutを設定
        //requireActivity().setContentView(layout1)

        *//*val parent:ViewGroup = layout1.parent as ViewGroup
        if (parent != null){
            parent.removeAllViews()
            Log.i("layout1removed","$parent")
        }*

        */





        val database = ItemDatabase.getInstance(requireActivity())
        val itemDao = database.itemDao()
        val strongFashionComponentList = when (judgeBoneTypeNum) {
            //item_bone_typeが0（ストレートタイプ）のアイテムを抽出
            0 -> itemDao.getStrongStraightAll()
            1 -> itemDao.getStrongWaveAll()
            2 -> itemDao.getStrongNaturalAll()
            //ダミー
            else -> itemDao.getStrongNaturalAll()
        }

        val strongItemImageView: MutableList<ImageView> = mutableListOf()
        for (num in strongFashionComponentList.indices) {
            strongItemImageView.add(ImageView(context)) //ImageViewをデータの数だけ生成
            strongItemImageView[num].setImageResource(strongItemResource[num])  //ImageViewに画像セット
            //ImageViewの横幅、高さ、割合をコンストラクタで設定
            val imageWidth = 0
            val imageHeight = 360
            val imageWeight = 1F
            val layoutParams: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(imageWidth, imageHeight, imageWeight)
            layoutParams.marginStart = 2
            layoutParams.marginEnd = 2
            layoutParams.bottomMargin = 1
            //設定したlayoutParamsを適用したいViewのlayoutParamsプロパティに設定
            strongItemImageView[num].layoutParams = layoutParams

            // fragment_result.xmlから取得したlayoutにimageViewを追加
            //imageViewが4つ以上で次のレイアウトを取得
            if (4 > num) {
                val strongItemLayout01 =
                    requireActivity().findViewById<LinearLayout>(R.id.strongItemLayout01)
                strongItemLayout01.addView(strongItemImageView[num])
            } else if (3 < num) {
                val strongItemLayout02 =
                    requireActivity().findViewById<LinearLayout>(R.id.strongItemLayout02)
                strongItemLayout02.addView(strongItemImageView[num])
            }

            //nullじゃなければscaleUpImageを呼び出して画像拡大＆詳細情報表示
            if (strongItemImageView[num] != null && strongFashionComponentList[num] != null) {
                scaleUpImage(strongItemImageView[num],
                    strongFashionComponentList[num].item_name,
                    strongFashionComponentList[num].item_description)
            }
        }
    }
}
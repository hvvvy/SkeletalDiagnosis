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

        //診断結果に応じて結果画面に表示する画像をセットする処理
        createResultScreen(User.userBoneType)

        view.findViewById<Button>(R.id.toHomeButton).setOnClickListener {
            findNavController().navigate(R.id.action_Result_to_Home)
        }

        view.findViewById<Button>(R.id.toRecommendOutfitButton).setOnClickListener {
            val action = ResultDirections.actionResultToRecommendOutfit(1,User.userBoneType)
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
        val resultText = view?.findViewById<TextView>(R.id.resultText)
        val boneTypeText = getString(R.string.result_text, "ストレート")
        resultText?.text = boneTypeText

        //ここにコメントアウトしたwhen式使えるかも
        val strongItemResource = listOf(R.drawable.v_neck_tops,
            R.drawable.v_neck_tops,
            R.drawable.v_neck_tops,
            R.drawable.v_neck_tops,
            R.drawable.v_neck_tops,
            R.drawable.v_neck_tops,
            R.drawable.v_neck_tops)

        val weaknessItemResource = listOf(R.drawable.food_blouson,
            R.drawable.food_blouson,
            R.drawable.food_blouson,
            R.drawable.food_blouson,
            R.drawable.food_blouson,
            R.drawable.food_blouson,
            R.drawable.food_blouson)


        val database = ItemDatabase.getInstance(requireActivity())
        val itemDao = database.itemDao()
        when (judgeBoneTypeNum) {
            0 -> {
                val resultText = view?.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ストレート")
                resultText?.text = boneTypeText
                imageSet(itemDao.getStrongStraightAll(), strongItemResource, 0)
                imageSet(itemDao.getWeaknessStraightAll(), weaknessItemResource, 1)
            }
            1 -> {
                val resultText = view?.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ウェーブ")
                resultText?.text = boneTypeText
                imageSet(itemDao.getStrongWaveAll(), strongItemResource, 0)
                imageSet(itemDao.getWeaknessWaveAll(), weaknessItemResource, 1)
            }
            2 -> {
                val resultText = view?.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ナチュラル")
                resultText?.text = boneTypeText
                imageSet(itemDao.getStrongNaturalAll(), strongItemResource, 0)
                imageSet(itemDao.getWeaknessNaturalAll(), weaknessItemResource, 1)
            }
        }

    }

    private fun imageSet(
        fashionComponentList: List<Item>,
        imageResource: List<Int>,
        strongOrWeaknessJudgeFlg: Int,
    ) {
        val fashionComponentImageView: MutableList<ImageView> = mutableListOf()
        for (num in fashionComponentList.indices) {
            fashionComponentImageView.add(ImageView(context)) //ImageViewをデータの数だけ生成
            //item_imageに格納しているリソース画像のファイル名を取得し、文字列からInt型へ変換
            val strId = resources.getIdentifier(fashionComponentList[num].item_image,"drawable", requireActivity().packageName)
            Log.i("strId","$strId")
            fashionComponentImageView[num].setImageResource(strId)  //ImageViewに画像セット

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
            fashionComponentImageView[num].layoutParams = layoutParams

            //得意ファッション要素か苦手ファッション要素かを判断
            //得意な場合
            if (0 == strongOrWeaknessJudgeFlg) {
                //ファッション要素のitem_category_idでカテゴリを判断
                if (5 == fashionComponentList[num].item_category_id) {  //item_category_id == 5は柄
                    //imageViewが4つ以上で次のLinerLayautへ移行
                    if (4 > num) {
                        // fragment_result.xmlから取得したlayoutにimageViewを追加
                        val strongPatternLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongPatternLayout01)
                        strongPatternLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < num) {
                        val strongPatternLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongPatternLayout02)
                        strongPatternLayout02.addView(fashionComponentImageView[num])
                    }
                } else if (6 == fashionComponentList[num].item_category_id) {   //item_category_id == 6は生地
                    //imageViewが4つ以上で次のLinerLayautへ移行
                    if (4 > num) {
                        val strongMaterialLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongMaterialLayout01)
                        strongMaterialLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < num) {
                        val strongMaterialLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongMaterialLayout02)
                        strongMaterialLayout02.addView(fashionComponentImageView[num])
                    }
                } else {    //item_category_id == 0～4はアイテム
                    //imageViewが4つ以上で次のLinerLayautへ移行
                    if (4 > num) {
                        val strongItemLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongItemLayout01)
                        strongItemLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < num) {
                        val strongItemLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongItemLayout02)
                        strongItemLayout02.addView(fashionComponentImageView[num])
                    }
                }
                //得意ファッション要素か苦手ファッション要素かを判断
                //苦手な場合
            } else {
                //ファッション要素のitem_category_idでカテゴリを判断

                if (5 == fashionComponentList[num].item_category_id) {  //item_category_id == 5は柄
                    //imageViewが4つ以上で次のLinerLayautへ移行
                    if (4 > num) {
                        // fragment_result.xmlから取得したlayoutにimageViewを追加
                        val weaknessItemLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout01)
                        weaknessItemLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < num) {
                        val weaknessItemLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout02)
                        weaknessItemLayout02.addView(fashionComponentImageView[num])
                    }
                } else if (6 == fashionComponentList[num].item_category_id) {   //item_category_id == 6は生地
                    //imageViewが4つ以上で次のLinerLayautへ移行
                    if (4 > num) {
                        val weaknessItemLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout01)
                        weaknessItemLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < num) {
                        val weaknessItemLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout02)
                        weaknessItemLayout02.addView(fashionComponentImageView[num])
                    }
                } else {    //item_category_id == 0～4はアイテム
                    //imageViewが4つ以上で次のLinerLayautへ移行
                    if (4 > num) {
                        val weaknessItemLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout01)
                        weaknessItemLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < num) {
                        val weaknessItemLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout02)
                        weaknessItemLayout02.addView(fashionComponentImageView[num])
                    }
                }

            }

            //nullじゃなければscaleUpImageを呼び出して画像拡大＆詳細情報表示
            if (fashionComponentImageView[num] != null && fashionComponentList[num] != null) {
                scaleUpImage(fashionComponentImageView[num],
                    fashionComponentList[num].item_name,
                    fashionComponentList[num].item_description)
            }
        }

    }
}
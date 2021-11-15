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

        //診断結果に応じて結果画面に表示する画像をセットする処理
        createResultScreen(User.userBoneType)

        view.findViewById<Button>(R.id.toHomeButton).setOnClickListener {
            findNavController().navigate(R.id.action_Result_to_Home)
        }

        view.findViewById<Button>(R.id.toRecommendOutfitButton).setOnClickListener {
            val action = ResultDirections.actionResultToRecommendOutfit(1, User.userBoneType)
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

        /*val resultText = view?.findViewById<TextView>(R.id.resultText)
        val boneTypeText = getString(R.string.result_text, "ストレート")
        resultText?.text = boneTypeText*/

        when (judgeBoneTypeNum) {
            0 -> {
                //Userクラスから取得した骨格タイプをもとに、R.id.resultTextにセットする骨格タイプ名を選択
                val resultText = view?.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ストレート")
                resultText?.text = boneTypeText
                //アイテム欄の説明文章を対応する骨格タイプのものに変更
                val itemCommentText = view?.findViewById<TextView>(R.id.itemCommentText)
                itemCommentText?.setText(R.string.straight_item_comment_text) 
                //素材欄の説明文章を対応する骨格タイプのものに変更
                val materialCommentText = view?.findViewById<TextView>(R.id.materialCommentText)
                materialCommentText?.setText(R.string.straight_material_comment_text) 
                //柄欄の説明文章を対応する骨格タイプのものに変更
                val patternCommentText = view?.findViewById<TextView>(R.id.patternCommentText)
                patternCommentText?.setText(R.string.straight_pattern_comment_text) 
                //骨格タイプの説明文章を対応する骨格タイプのものに変更
                val boneTypeDescriptionCommentText = view?.findViewById<TextView>(R.id.boneTypeDescriptionCommentText)
                boneTypeDescriptionCommentText?.setText(R.string.straight_description_comment_text) 
                //ワンポイントアドバイス欄の説明文章を対応する骨格タイプのものに変更
                val onePointAdviceCommentText = view?.findViewById<TextView>(R.id.onePointAdviceCommentText)
                onePointAdviceCommentText?.setText(R.string.straight_one_point_advice_comment_text)
                
                //DBから各骨格タイプの得意or不得意アイテム（柄、素材含む）を取得
                val database = ItemDatabase.getInstance(requireActivity())
                val itemDao = database.itemDao()
                imageSet(itemDao.getStrongStraightAll(), 0)
                imageSet(itemDao.getWeaknessStraightAll(), 1)
            }
            1 -> {
                //Userクラスから取得した骨格タイプをもとに、R.id.resultTextにセットする骨格タイプ名を選択
                val resultText = view?.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ウェーブ")
                resultText?.text = boneTypeText

                //アイテム欄の説明文章を対応する骨格タイプのものに変更
                val itemCommentText = view?.findViewById<TextView>(R.id.itemCommentText)
                itemCommentText?.setText(R.string.wave_item_comment_text)
                //素材欄の説明文章を対応する骨格タイプのものに変更
                val materialCommentText = view?.findViewById<TextView>(R.id.materialCommentText)
                materialCommentText?.setText(R.string.wave_material_comment_text)
                //柄欄の説明文章を対応する骨格タイプのものに変更
                val patternCommentText = view?.findViewById<TextView>(R.id.patternCommentText)
                patternCommentText?.setText(R.string.wave_pattern_comment_text)
                //骨格タイプの説明文章を対応する骨格タイプのものに変更
                val boneTypeDescriptionCommentText = view?.findViewById<TextView>(R.id.boneTypeDescriptionCommentText)
                boneTypeDescriptionCommentText?.setText(R.string.wave_description_comment_text)
                //ワンポイントアドバイス欄の説明文章を対応する骨格タイプのものに変更
                val onePointAdviceCommentText = view?.findViewById<TextView>(R.id.onePointAdviceCommentText)
                onePointAdviceCommentText?.setText(R.string.wave_one_point_advice_comment_text)

                //DBから各骨格タイプの得意or不得意アイテム（柄、素材含む）を取得
                val database = ItemDatabase.getInstance(requireActivity())
                val itemDao = database.itemDao()
                imageSet(itemDao.getStrongWaveAll(), 0)
                imageSet(itemDao.getWeaknessWaveAll(), 1)
            }
            2 -> {
                //Userクラスから取得した骨格タイプをもとに、R.id.resultTextにセットする骨格タイプ名を選択
                val resultText = view?.findViewById<TextView>(R.id.resultText)
                val boneTypeText = getString(R.string.result_text, "ナチュラル")
                resultText?.text = boneTypeText

                //アイテム欄の説明文章を対応する骨格タイプのものに変更
                val itemCommentText = view?.findViewById<TextView>(R.id.itemCommentText)
                itemCommentText?.setText(R.string.natural_item_comment_text)
                //素材欄の説明文章を対応する骨格タイプのものに変更
                val materialCommentText = view?.findViewById<TextView>(R.id.materialCommentText)
                materialCommentText?.setText(R.string.natural_material_comment_text)
                //柄欄の説明文章を対応する骨格タイプのものに変更
                val patternCommentText = view?.findViewById<TextView>(R.id.patternCommentText)
                patternCommentText?.setText(R.string.natural_pattern_comment_text)
                //骨格タイプの説明文章を対応する骨格タイプのものに変更
                val boneTypeDescriptionCommentText = view?.findViewById<TextView>(R.id.boneTypeDescriptionCommentText)
                boneTypeDescriptionCommentText?.setText(R.string.natural_description_comment_text)
                //ワンポイントアドバイス欄の説明文章を対応する骨格タイプのものに変更
                val onePointAdviceCommentText = view?.findViewById<TextView>(R.id.onePointAdviceCommentText)
                onePointAdviceCommentText?.setText(R.string.natural_one_point_advice_comment_text)

                //DBから各骨格タイプの得意or不得意アイテム（柄、素材含む）を取得
                val database = ItemDatabase.getInstance(requireActivity())
                val itemDao = database.itemDao()
                imageSet(itemDao.getStrongNaturalAll(), 0)
                imageSet(itemDao.getWeaknessNaturalAll(), 1)
            }
        }
    }

    private fun imageSet(
        fashionComponentList: List<Item>,
        strongOrWeaknessJudgeFlg: Int,
    ) {
        val fashionComponentImageView: MutableList<ImageView> = mutableListOf()
        //テスト運用
        var strongItemImageViewCount = 0
        var strongPatternImageViewCount = 0
        var strongMaterialImageViewCount = 0
        var weaknessItemImageViewCount = 0
        var weaknessPatternImageViewCount = 0
        var weaknessMaterialImageViewCount = 0

        for (num in fashionComponentList.indices) {
            fashionComponentImageView.add(ImageView(context)) //ImageViewをデータの数だけ生成
            //item_imageカラムに格納しているリソース画像のファイル名を取得し、文字列からInt型へ変換してstrIdに格納
            val strId = resources.getIdentifier(fashionComponentList[num].item_image,
                "drawable",
                requireActivity().packageName)
            Log.i("strId", "$strId")
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
                    //strongPatternImageViewCountが4つ以上で次のLinerLayautへ移行
                    if (4 > strongPatternImageViewCount) {
                        // fragment_result.xmlから取得したlayoutにimageViewを追加
                        val strongPatternLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongPatternLayout01)
                        strongPatternLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < strongPatternImageViewCount) {
                        val strongPatternLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongPatternLayout02)
                        strongPatternLayout02.addView(fashionComponentImageView[num])
                    }else if (7 < strongPatternImageViewCount) {
                        val strongPatternLayout03 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongPatternLayout03)
                        strongPatternLayout03.addView(fashionComponentImageView[num])
                    } else if (11 < strongPatternImageViewCount) {
                        val strongPatternLayout04 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongPatternLayout04)
                        strongPatternLayout04.addView(fashionComponentImageView[num])
                    }
                    strongPatternImageViewCount += 1  //得意柄項目のImageViewのcount数を1増やす
                    Log.i("countPattern", "$strongPatternImageViewCount")
                } else if (6 == fashionComponentList[num].item_category_id) {   //item_category_id == 6は素材
                    //strongMaterialImageViewCountが4つ以上で次のLinerLayautへ移行
                    if (4 > strongMaterialImageViewCount) {
                        val strongMaterialLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongMaterialLayout01)
                        strongMaterialLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < strongMaterialImageViewCount) {
                        val strongMaterialLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongMaterialLayout02)
                        strongMaterialLayout02.addView(fashionComponentImageView[num])
                    }else if (7 < strongMaterialImageViewCount) {
                        val strongMaterialLayout03 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongMaterialLayout03)
                        strongMaterialLayout03.addView(fashionComponentImageView[num])
                    }else if (11 < strongMaterialImageViewCount) {
                        val strongMaterialLayout04 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongMaterialLayout04)
                        strongMaterialLayout04.addView(fashionComponentImageView[num])
                    }
                    strongMaterialImageViewCount += 1 //得意素材項目のImageViewのcount数を1増やす
                } else {    //item_category_id == 0～4はアイテム
                    //strongItemImageViewCountが4つ以上で次のLinerLayautへ移行
                    if (4 > strongItemImageViewCount) {
                        val strongItemLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongItemLayout01)
                        strongItemLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < strongItemImageViewCount) {
                        val strongItemLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongItemLayout02)
                        strongItemLayout02.addView(fashionComponentImageView[num])
                    }else if (7 < strongItemImageViewCount) {
                        val strongItemLayout03 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongItemLayout03)
                        strongItemLayout03.addView(fashionComponentImageView[num])
                    }else if (11 < strongItemImageViewCount) {
                        val strongItemLayout04 =
                            requireActivity().findViewById<LinearLayout>(R.id.strongItemLayout04)
                        strongItemLayout04.addView(fashionComponentImageView[num])
                    }
                    strongItemImageViewCount += 1 //得意アイテム項目のImageViewのcount数を1増やす
                }
                //得意ファッション要素か苦手ファッション要素かを判断
                //苦手な場合
            } else {
                //ファッション要素のitem_category_idでカテゴリを判断
                if (5 == fashionComponentList[num].item_category_id) {  //item_category_id == 5は柄
                    /*
                    //ImageViewCountが4つ以上で次のLinerLayautへ移行
                    if (4 > weaknessPatternImageViewCount) {
                        // fragment_result.xmlから取得したlayoutにimageViewを追加
                        val weaknessItemLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout01)
                        weaknessItemLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < weaknessPatternImageViewCount) {
                        val weaknessItemLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout02)
                        weaknessItemLayout02.addView(fashionComponentImageView[num])
                    }
                    weaknessPatternImageViewCount += 1  //苦手柄項目のImageViewのcount数を1増やす
                    */
                } else if (6 == fashionComponentList[num].item_category_id) {   //item_category_id == 6は素材
                    //ImageViewCountが4つ以上で次のLinerLayautへ移行
                    if (4 > weaknessMaterialImageViewCount) {
                        val weaknessMaterialLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessMaterialLayout01)
                        weaknessMaterialLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < weaknessMaterialImageViewCount) {
                        val weaknessMaterialLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessMaterialLayout02)
                        weaknessMaterialLayout02.addView(fashionComponentImageView[num])
                    }else if (7 < weaknessMaterialImageViewCount) {
                        val weaknessMaterialLayout03 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessMaterialLayout03)
                        weaknessMaterialLayout03.addView(fashionComponentImageView[num])
                    }else if (11 < weaknessMaterialImageViewCount) {
                        val weaknessMaterialLayout04 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessMaterialLayout04)
                        weaknessMaterialLayout04.addView(fashionComponentImageView[num])
                    }
                    weaknessMaterialImageViewCount += 1  //苦手素材項目のImageViewのcount数を1増やす
                } else {    //item_category_id == 0～4はアイテム
                    //ImageViewCountが4つ以上で次のLinerLayautへ移行
                    if (4 > weaknessItemImageViewCount) {
                        val weaknessItemLayout01 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout01)
                        weaknessItemLayout01.addView(fashionComponentImageView[num])
                    } else if (3 < weaknessItemImageViewCount) {
                        val weaknessItemLayout02 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout02)
                        weaknessItemLayout02.addView(fashionComponentImageView[num])
                    }else if (7 < weaknessItemImageViewCount) {
                        val weaknessItemLayout03 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout03)
                        weaknessItemLayout03.addView(fashionComponentImageView[num])
                    }else if (11 < weaknessItemImageViewCount) {
                        val weaknessItemLayout04 =
                            requireActivity().findViewById<LinearLayout>(R.id.weaknessItemLayout04)
                        weaknessItemLayout04.addView(fashionComponentImageView[num])
                    }
                    weaknessItemImageViewCount += 1  //苦手アイテム項目のImageViewのcount数を1増やす
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
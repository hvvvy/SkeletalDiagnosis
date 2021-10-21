package com.example.skeletaldiagnosis

import android.app.AlertDialog
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
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


        val resultText = view.findViewById<TextView>(R.id.resultText)
        when (User.userBoneType) {
            //骨格タイプがストレートだった場合の結果画面に表示するテキストや画像
            0 -> {
                val boneTypeText = getString(R.string.result_text, "ストレート")
                resultText.text = boneTypeText

                /*
                //item_bone_typeが0（ストレートタイプ）のアイテムを抽出
                val strongItemList = itemDao.getStrongStraightAll()
                while (strongItemList.isEmpty()){
                    val strongItemIamge = ImageView(context)
                    strongItemIamge.setImageResource(strongItemList.indexOf(0))
                }
                */

                //得意アイテムに張り替える処理
                //ここら辺は省略するためにメソッドで対応？
                view.findViewById<ImageView>(R.id.strongItem01)
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
                val boneTypeText = getString(R.string.result_text, "ウェーブ")
                resultText.text = boneTypeText

                view.findViewById<ImageView>(R.id.strongItem01)
                    .setImageResource(R.drawable.food_blouson)
            }
            //骨格タイプがナチュラルだった場合の結果画面に表示するテキストや画像
            2 -> {
                val boneTypeText = getString(R.string.result_text, "ナチュラル")
                resultText.text = boneTypeText
            }


        }

        scaleUpImage(view.findViewById(R.id.strongItem01), "a")






        view.findViewById<Button>(R.id.toHomeButton).setOnClickListener {
            findNavController().navigate(R.id.action_Result_to_Home)
        }
        view.findViewById<Button>(R.id.toRecommendOutfitButton).setOnClickListener {
            val action = ResultDirections.actionResultToRecommendOutfit(1)
            findNavController().navigate(action)

        }

    }

    fun scaleUpImage(image: ImageView, name: String){
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
            builder.setTitle("白Tシャツ")
            //説明文はDBから取得
            builder.setMessage("白いTシャツ。それはそれは白いTシャツ。")
            builder.setNegativeButton("閉じる", null)
            builder.show()


        }
    }

}
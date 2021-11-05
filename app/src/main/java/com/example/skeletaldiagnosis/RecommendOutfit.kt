package com.example.skeletaldiagnosis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class RecommendOutfit : Fragment() {
    private val args: RecommendOutfitArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend_outfit, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boneTypeId = args?.judgeBoneTypeId
        judgeBoneTypeAndDisplayTheImage(boneTypeId)

        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            var flgBeforeScreen = args.flgBeforeScreen
            //戻るボタンを押下した場合に遷移前の画面へ戻る
                if (flgBeforeScreen == 0) {
                    findNavController().navigate(R.id.action_RecommendOutfit_to_Home)
                } else if (flgBeforeScreen == 1) {
                    findNavController().navigate(R.id.action_RecommendOutfit_to_Result)
                }
           // }
        }
    }
    private fun judgeBoneTypeAndDisplayTheImage(boneTypeId: Int){
        val recommendOutfitImage = view?.findViewById<ImageView>(R.id.toDayRecommendOutfit)
        when(boneTypeId){
            0 -> {
                //画像仮置き
                val recommendOutfitImageList = listOf(R.drawable.straight_styling01,R.drawable.straight_styling02,R.drawable.straight_styling03)
                val range = (recommendOutfitImageList.indices)
                val randomStraightStyling = range.random()
                recommendOutfitImage?.setImageResource(recommendOutfitImageList[randomStraightStyling])
            }
            1 -> {
                //画像仮置き
                val recommendOutfitImageList = listOf(R.drawable.straight_styling01,R.drawable.straight_styling02,R.drawable.straight_styling03)
                val range = (recommendOutfitImageList.indices)
                val randomStraightStyling = range.random()
                recommendOutfitImage?.setImageResource(recommendOutfitImageList[randomStraightStyling])
            }
            2 -> {
                //画像仮置き
                val recommendOutfitImageList = listOf(R.drawable.straight_styling01,R.drawable.straight_styling02,R.drawable.straight_styling03)
                val range = (recommendOutfitImageList.indices)
                val randomStraightStyling = range.random()
                recommendOutfitImage?.setImageResource(recommendOutfitImageList[randomStraightStyling])
            }
        }

    }


}
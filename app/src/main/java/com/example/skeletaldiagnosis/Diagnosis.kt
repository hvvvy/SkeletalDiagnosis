package com.example.skeletaldiagnosis

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.time.LocalDate



class Diagnosis : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diagnosis, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var questionEndCheck  = 0
        val analysis = Analysis(LocalDate.now(),view,0,0,0,0)


        val choiceStraightButton = view.findViewById<Button>(R.id.choiceStraightButton)
        choiceStraightButton.setOnClickListener {
            //選択ボタンを押下するたびonBoneTypeChoiceButtonClickからquestionsCountを随時取得しquestionEndCheckに格納
            questionEndCheck  = analysis.onBoneTypeChoiceButtonClick(view,0)

            Log.i("iSearch","$questionEndCheck")
            //questionEndCheckが7以上になった場合、つまり質問が終了した場合、診断終了画面に遷移し、質問のカウント数を初期化する
            if (questionEndCheck > 7){
                findNavController().navigate(R.id.action_Diagnosis_to_DiagnosisEnd)
                analysis.resetQuestion(view)
                //UserクラスのuserBoneTypeに分析した骨格タイプを格納
                User.userBoneType = analysis.analyzeBoneType()
                Log.i("userBoneTypeCheack","${User.userBoneType}")

            }
        }

        val choiceWaveButton = view.findViewById<Button>(R.id.choiceWaveButton)
        choiceWaveButton.setOnClickListener {
            //選択ボタンを押下するたびonBoneTypeChoiceButtonClickからquestionsCountを随時取得しquestionEndCheckに格納
            questionEndCheck = analysis.onBoneTypeChoiceButtonClick(view,1)

            Log.i("iSearch","$questionEndCheck")
            //questionEndCheckが7以上になった場合、つまり質問が終了した場合、診断終了画面に遷移し、質問のカウント数を初期化する
            if (questionEndCheck > 7){
                findNavController().navigate(R.id.action_Diagnosis_to_DiagnosisEnd)
                analysis.resetQuestion(view)
                //UserクラスのuserBoneTypeに分析した骨格タイプを格納
                User.userBoneType = analysis.analyzeBoneType()
                Log.i("userBoneTypeCheack","${User.userBoneType}")
            }
        }

        val choiceNaturalButton = view.findViewById<Button>(R.id.choiceNaturalButton)
        choiceNaturalButton.setOnClickListener {
            //選択ボタンを押下するたびonBoneTypeChoiceButtonClickからquestionsCountを随時取得しquestionEndCheckに格納
            questionEndCheck = analysis.onBoneTypeChoiceButtonClick(view,2)

            Log.i("iSearch","$questionEndCheck")
            //questionEndCheckが7以上になった場合、つまり質問が終了した場合、診断終了画面に遷移し、質問のカウント数を初期化する
            if (questionEndCheck > 7){
                findNavController().navigate(R.id.action_Diagnosis_to_DiagnosisEnd)
                analysis.resetQuestion(view)
                //UserクラスのuserBoneTypeに分析した骨格タイプを格納
                User.userBoneType = analysis.analyzeBoneType()
                Log.i("userBoneTypeCheack","${User.userBoneType}")

            }
        }

    }

}
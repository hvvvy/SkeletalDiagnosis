package com.example.skeletaldiagnosis

import android.app.Dialog
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.view.Display
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import java.time.LocalDate

class Analysis(val date: LocalDate, var view:View ,var straightTypePoint: Int, var waveTypePoint: Int, var naturalTypePoint: Int,var boneType: Int) {

    //何番目の質問かをカウントする
    private var questionsCount = 0

    private val questionText = view.findViewById<TextView>(R.id.questionText)
    private val choiceStraightButton = view.findViewById<Button>(R.id.choiceStraightButton)
    private val choiceWaveButton = view.findViewById<Button>(R.id.choiceWaveButton)
    private val choiceNaturalButton = view.findViewById<Button>(R.id.choiceNaturalButton)

    fun analyzeBoneType():Int {
        //straightTypePoint,waveTypePoint,naturalTypePointを比較し、最大値だった骨格ポイントを判定してboneTypeにInt型で骨格タイプを割り振る
        //このメソッドはDiagnosis.ktの選択ボタン押下後のif文内(質問が終了した段階)で呼び出される

        if (straightTypePoint >= waveTypePoint && straightTypePoint >= naturalTypePoint){   //straightTypePointが最大値の場合
            //0 == ストレートタイプ
            boneType = 0
        }else if (waveTypePoint >= straightTypePoint && waveTypePoint >= naturalTypePoint){ //waveTypePointが最大値の場合
            //1 == ウェーブタイプ
            boneType = 1
        }else if (naturalTypePoint >= straightTypePoint && naturalTypePoint >= waveTypePoint){  //naturalTypePointが最大値の場合
            //2 == ナチュラルタイプ
            boneType = 2
        }

        return boneType
    }

    fun displayAnalysisResult() {}

    fun resetQuestion(view: View){

        questionsCount = 0

        questionText.text = R.string.question_text.toString()
        choiceStraightButton.text = R.string.straight_choice_question.toString()
        choiceWaveButton.text = R.string.wave_choice_question.toString()
        choiceNaturalButton.text = R.string.natural_choice_question.toString()
    }


    private val questions = listOf(
        "Q2.筋肉や脂肪の付き具合は？",
        "Q3.肌の質感は？",
        "Q4.首の長さや特徴は？",
        "Q5.鎖骨の出方は？",
        "Q6.手首の特徴は？",
        "Q7.ヒップラインの特徴は？",
        "Q8.膝の特徴は？")
    private val selectStraightAnswer = listOf(
        "筋肉がつきやすい",
        "弾力があり、ハリもある",
        "短い",
        "ほとんど目立たない",
        "肉感があり骨は目立たない",
        "丸みがあり立体的",
        "小さく丸く、目立たない")
    private val selectWaveAnswer = listOf(
        "筋肉よりも脂肪の方がつきやすい",
        "表皮が薄く、ソフトな質感",
        "細く長い",
        "鎖骨は細く、やや目立つ",
        "細く骨は少し目立つ",
        "なだらかに下がって見える",
        "小さく丸く、少し目立つ")
    private val selectNaturalAnswer = listOf(
        "筋肉や脂肪よりも骨ばった身体が目立つ",
        "肌質は硬く、筋が目立つ",
        "首はやや太く、筋が目立つ",
        "存在感があり服の上からでも分かる",
        "細く骨がかなり目立つ",
        "小さく平面的",
        "縦に長くかなり目立つ")


    //各骨格タイプのchoiceButtonを押下時に全てのボタンのテキストを変更する
    //onBoneTypeChoiceButtonClick(view: View)メソッド内で使用する
    private fun showNextQuestions(view: View) {


        //質問数が初期表示を除き8個ある
        //8個までは順次テキストを入れ替える
        if (questionsCount < 7) {

            questionText.text = questions[questionsCount]
            choiceStraightButton.text = selectStraightAnswer[questionsCount]
            choiceWaveButton.text = selectWaveAnswer[questionsCount]
            choiceNaturalButton.text = selectNaturalAnswer[questionsCount]

        }
        questionsCount += 1
        Log.i("QuestionCount", "$questionsCount")
    }


    fun onBoneTypeChoiceButtonClick(view: View, boneTypeFlg: Int): Int {
        Log.i("ButtonTapped", "$view")


        showNextQuestions(view)

        when (boneTypeFlg) {
            0 -> {
                ++straightTypePoint
                Log.i("straightButtonChoice", "$straightTypePoint")

            }

            1 -> {
                ++waveTypePoint
                Log.i("waveButtonChoice", "$waveTypePoint")
            }


            2 -> {
                ++naturalTypePoint
                Log.i("naturalButtonChoice", "$naturalTypePoint")

            }
        }


        return questionsCount
    }

}



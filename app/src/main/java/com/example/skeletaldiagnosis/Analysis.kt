package com.example.skeletaldiagnosis

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.time.LocalDate

class Analysis(val date: LocalDate, var straightTypePoint: Int, var waveTypePoint: Int, var naturalTypePoint: Int) {


    fun analyzeBoneType() {}

    fun displayAnalysisResult() {}

    fun resetQuestion(view: View){
        val questionText = view.findViewById<TextView>(R.id.questionText)
        val choiceStraightButton = view.findViewById<Button>(R.id.choiceStraightButton)
        val choiceWaveButton = view.findViewById<Button>(R.id.choiceWaveButton)
        val choiceNaturalButton = view.findViewById<Button>(R.id.choiceNaturalButton)

        questionsCount = 0

        questionText.text = R.string.question_text.toString()
        choiceStraightButton.text = R.string.straight_choice_question.toString()
        choiceWaveButton.text = R.string.wave_choice_question.toString()
        choiceNaturalButton.text = R.string.natural_choice_question.toString()

    }

    var questionsCount = 0

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

        val questionText = view.findViewById<TextView>(R.id.questionText)
        val choiceStraightButton = view.findViewById<Button>(R.id.choiceStraightButton)
        val choiceWaveButton = view.findViewById<Button>(R.id.choiceWaveButton)
        val choiceNaturalButton = view.findViewById<Button>(R.id.choiceNaturalButton)


        //質問数が初期表示を除き8個ある
        //8個までは順次テキストを入れ替えていき、8個を超えた時点で結果画面へ遷移する
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



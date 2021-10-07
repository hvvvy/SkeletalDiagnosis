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
        val analysis = Analysis(LocalDate.now(),0,0,0)


        val choiceStraightButton = view.findViewById<Button>(R.id.choiceStraightButton)
        choiceStraightButton.setOnClickListener {
            questionEndCheck  = analysis.onBoneTypeChoiceButtonClick(view,0)

            Log.i("iSearch","$questionEndCheck")
            if (questionEndCheck > 7){
                findNavController().navigate(R.id.action_Diagnosis_to_DiagnosisEnd)
                analysis.resetQuestion(view)
            }
        }

        val choiceWaveButton = view.findViewById<Button>(R.id.choiceWaveButton)
        choiceWaveButton.setOnClickListener {
            questionEndCheck = analysis.onBoneTypeChoiceButtonClick(view,1)

            Log.i("iSearch","$questionEndCheck")
            if (questionEndCheck > 7){
                findNavController().navigate(R.id.action_Diagnosis_to_DiagnosisEnd)
                analysis.resetQuestion(view)
            }
        }

        val choiceNaturalButton = view.findViewById<Button>(R.id.choiceNaturalButton)
        choiceNaturalButton.setOnClickListener {
            questionEndCheck = analysis.onBoneTypeChoiceButtonClick(view,2)

            Log.i("iSearch","$questionEndCheck")
            if (questionEndCheck > 7){
                findNavController().navigate(R.id.action_Diagnosis_to_DiagnosisEnd)
                analysis.resetQuestion(view)
            }
        }

    }

}
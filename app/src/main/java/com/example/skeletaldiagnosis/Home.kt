package com.example.skeletaldiagnosis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class
Home : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.diagnosisStartButton).setOnClickListener {
            findNavController().navigate(R.id.action_Home_to_Diagnosis)
        }
        view.findViewById<Button>(R.id.outfitButton).setOnClickListener {
            //val action = R.id.action_Home_to_RecommendOutfit("a")
            val action = HomeDirections.actionHomeToRecommendOutfit(0)
            findNavController().navigate(action)
        }
        view.findViewById<Button>(R.id.creditButton).setOnClickListener {
            findNavController().navigate(R.id.action_Home_to_Credit)
        }

    }
}
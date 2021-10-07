package com.example.skeletaldiagnosis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        var flgBeforeScreen = args?.flgBeforeScreen

        view.findViewById<Button>(R.id.backButton).setOnClickListener {

            //if (flgBeforeScreen != null) {
                if (flgBeforeScreen == 0) {
                    findNavController().navigate(R.id.action_RecommendOutfit_to_Home)
                } else if (flgBeforeScreen == 1) {
                    findNavController().navigate(R.id.action_RecommendOutfit_to_Result)
                }
           // }
        }
    }


}
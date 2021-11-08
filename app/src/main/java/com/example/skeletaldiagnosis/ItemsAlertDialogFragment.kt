package com.example.skeletaldiagnosis


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController

class ItemsAlertDialogFragment : DialogFragment() {

    companion object {
        // リストに表示する値を配列として定義
        val BoneTypes = arrayOf("ストレートタイプ", "ウェーブタイプ", "ナチュラルタイプ")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.dialog_title)
            .setItems(BoneTypes) { dialog, which ->
                // BoneTypesのリストのどれかが選択されたときに実行される処理
                // whichはBoneTypes配列の選択されたインデックス
                Toast.makeText(context, "${BoneTypes[which]} が選択されました", Toast.LENGTH_SHORT).show()
                val action = HomeDirections.actionHomeToRecommendOutfit(0,which)
                findNavController().navigate(action)
            }
            .setNegativeButton(R.string.dialog_close, null)
            .create()
}
package com.example.mymoveapplication.ui.main

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.mymoveapplication.R


class DialogFragment : DialogFragment() {
    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
                //При запуске стоит False
            .setMessage(getText(R.id.tvNoteEditText))
                // Вместо 2 кнопок стоит с лева false ничего не падает
            .setPositiveButton(R.id.btnAddDetails) {_,_->}
            .create()
    // Сделать как у мужыка на видео(по старому методу) у него работает, вроде
    companion object {
        const val TAG = "DialogFragment"
    }
}
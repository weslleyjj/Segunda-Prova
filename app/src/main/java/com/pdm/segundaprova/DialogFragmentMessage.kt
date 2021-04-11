package com.pdm.segundaprova

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogFragmentMessage (content: Bundle): DialogFragment() {

    var content = content

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //uso de uma classe com padrão builder para construção da caixa de diálogo
        val builder= AlertDialog.Builder(requireActivity())

        builder.setTitle(content.getString("titulo"))

        builder.setMessage(content.getString("texto"))

        return builder.create()
    }
}
package com.pil.movieapp.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.pil.movieapp.R

class ErrorDialog {
    companion object {
        fun show(context: Context,title: String, message: String) {
            AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.OK, null)
                .setIcon(R.drawable.error)
                .show()
        }
    }
}
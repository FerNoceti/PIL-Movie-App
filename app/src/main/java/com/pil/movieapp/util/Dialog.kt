package com.pil.movieapp.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.pil.movieapp.R
import com.pil.movieapp.databinding.DialogBinding
import javax.annotation.Nullable

class Dialog : DialogFragment() {

    private lateinit var binding: DialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DialogBinding.inflate(inflater, container, false)

        binding.dialogButton.setOnClickListener { dismiss() }

        return inflater.inflate(R.layout.dialog, container, false)
    }
}
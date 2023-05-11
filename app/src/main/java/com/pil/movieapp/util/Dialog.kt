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

    private var _binding: DialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DialogBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val title = arguments?.getString(ARG_TITLE)
        binding.dialogTitle.text = title

        val message = arguments?.getString(ARG_MESSAGE)
        binding.dialogMessage.text = message

        binding.dialogButton.setOnClickListener { dismiss() }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_TITLE = "arg_title"
        private const val ARG_MESSAGE = "arg_message"

        fun newInstance(title: String, message: String): Dialog {
            val fragment = Dialog()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_MESSAGE, message)
            fragment.arguments = args
            return fragment
        }
    }
}
package com.pil.movieapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pil.movieapp.R
import com.pil.movieapp.databinding.ActivityMainBinding
import com.pil.movieapp.mvvm.viewmodel.MenuViewModel
import com.pil.movieapp.util.Dialog

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MenuViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getValue().observe(this) { updateUI(it) }

        binding.button.setOnClickListener { viewModel.buttonPressed() }
        binding.buttonError.setOnClickListener { viewModel.buttonErrorPressed() }
    }

    private fun updateUI(state: MenuViewModel.MenuStates) {
        when (state) {
            MenuViewModel.MenuStates.INIT -> {
            }

            MenuViewModel.MenuStates.GO_TO_MOVIE_SCREEN -> {
                val intent = Intent(this, MovieActivity::class.java)
                startActivity(intent)
            }

            MenuViewModel.MenuStates.ERROR -> {
                Dialog.newInstance(
                    getString(R.string.error_title),
                    getString(R.string.error_message),
                ).show(supportFragmentManager, "dialog")
            }
        }
    }
}

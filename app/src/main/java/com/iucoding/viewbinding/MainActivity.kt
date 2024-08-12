package com.iucoding.viewbinding

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iucoding.viewbinding.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel<MainViewModel>()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.submitButton.setOnClickListener {
            val name = binding.nameInput.text
            if (name.isNullOrBlank()) {
                showAlert("Please enter a valid name")
            } else showAlert("You entered \"$name\"")
        }
    }

    private fun showAlert(message: String) {
        val alertDialog = AlertDialog.Builder(this)
            .also {
                it.setMessage(message)
                it.setPositiveButton("OK") { _: DialogInterface, _: Int -> }
            }
            .create()
            .show()
    }
}

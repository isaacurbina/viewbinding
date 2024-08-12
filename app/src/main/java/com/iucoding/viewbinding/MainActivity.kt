package com.iucoding.viewbinding

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iucoding.viewbinding.databinding.ActivityMainBinding
import com.iucoding.viewbinding.recyclerview.adapter.HoursAdapter
import com.iucoding.viewbinding.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var hoursAdapter: HoursAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hoursAdapter = HoursAdapter {
            showAlert("clicked on $it")
        }
        binding.activityMainRecyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = hoursAdapter
        }
        binding.activityMainFetchButton.setOnClickListener {
            println("clicked on button")
            lifecycleScope.launch {
                println("fetching data")
                mainViewModel.fetchData().collect {
                    println("fetched $it")
                    hoursAdapter.submitList(it)
                }
            }
        }
    }

    private fun showAlert(message: String) {
        AlertDialog.Builder(this)
            .also {
                it.setMessage(message)
                it.setPositiveButton("OK") { _: DialogInterface, _: Int -> }
            }
            .create()
            .show()
    }
}

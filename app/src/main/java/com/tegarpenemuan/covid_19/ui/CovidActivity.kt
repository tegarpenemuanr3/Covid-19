package com.tegarpenemuan.covid_19.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.tegarpenemuan.covid_19.databinding.CovidMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CovidActivity : AppCompatActivity() {

    private lateinit var binding: CovidMainBinding
    private val viewModel: CovidViewModel by viewModels()
    private lateinit var adapter: CovidAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CovidMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CovidAdapter(
            list = emptyList()
        )
        binding.rvDataCovid.adapter = adapter

        bindViewModel()
        viewModel.getCovidProvince()
    }

    private fun bindViewModel() {
        viewModel.showError.observe(this) {
            val snackbar = Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
            snackbar.view.setBackgroundColor(Color.RED)
            snackbar.show()
        }

        viewModel.showData.observe(this) {
            val date = it.lastDate
            val data = it.listData

            binding.tvDateUpdate.text = "Update Data : $date"
            adapter.updateList(data)
        }
    }
}
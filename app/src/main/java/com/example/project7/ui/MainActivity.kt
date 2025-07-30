package com.example.project7.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project7.R
import com.example.project7.data.remote.NasaApiService
import com.example.project7.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var nasaAdapter: NasaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        nasaAdapter = NasaAdapter()
        recyclerView.adapter = nasaAdapter

        fetchNasaData()
    }

    private fun fetchNasaData() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getApodList(
                    apiKey = "YLAVGKHuPV7fIXaEZuZEreVzzLqHCJJkIJ644bWp" // Replace with your NASA API key
                )
                nasaAdapter.submitList(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}


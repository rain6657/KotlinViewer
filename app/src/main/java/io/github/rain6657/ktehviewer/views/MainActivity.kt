package io.github.rain6657.ktehviewer.views

import android.graphics.Color
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import io.github.rain6657.ktehviewer.viewmodels.MainViewModel
import io.github.rain6657.ktehviewer.databinding.ActivityMainBinding
import io.github.rain6657.ktehviewer.utils.network.EhApiService
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var vdb: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vdb = ActivityMainBinding.inflate(layoutInflater)


        setContentView(vdb.root)

        showToast("a")

        refresh()

    }

    public fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG)
    }

    fun refresh() {
        lifecycleScope.launch {
            EhApiService.EhApi.retrofitService.getHome()
        }
    }
}
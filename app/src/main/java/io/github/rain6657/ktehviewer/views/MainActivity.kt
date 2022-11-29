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
import io.github.rain6657.ktehviewer.models.GalleryList
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

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG)
    }

    private fun refresh() {
        lifecycleScope.launch {
            val body: String = EhApiService.EhApi.retrofitService.getHome()
            val gl = GalleryList.parse(body)
            return@launch
        }
    }
}
package io.github.rain6657.ktehviewer.views

import android.graphics.Color
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import io.github.rain6657.ktehviewer.viewmodels.MainViewModel
import io.github.rain6657.ktehviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var vdb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vdb = ActivityMainBinding.inflate(layoutInflater)

        setContentView(vdb.root)

    }
}
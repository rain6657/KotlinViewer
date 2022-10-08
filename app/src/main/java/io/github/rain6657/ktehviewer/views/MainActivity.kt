package io.github.rain6657.ktehviewer.views

import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.rain6657.ktehviewer.R
import io.github.rain6657.ktehviewer.viewmodels.MainViewModel
import io.github.rain6657.ktehviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val vm: MainViewModel by viewModels()
    private lateinit var vdb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vdb = ActivityMainBinding.inflate(layoutInflater)

        setContentView(vdb.root)
    }
}
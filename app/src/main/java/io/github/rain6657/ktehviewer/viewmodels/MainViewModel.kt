package io.github.rain6657.ktehviewer.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.rain6657.ktehviewer.models.GalleryInfo
import io.github.rain6657.ktehviewer.utils.network.EhApiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    public var searchTitleText: String? = null
    public var searchEditText: String? = null
    public var selectedMenuItem: String? = null
    public lateinit var galleryList: List<GalleryInfo>



    fun refresh() {
        viewModelScope.launch {
            val response = EhApiService.EhApi.retrofitService.getHome()
            val gallery = GalleryInfo.galleryInfoPhaser(response)
        }
    }
    // Todo: Implement the viewmodel
}
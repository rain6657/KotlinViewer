package io.github.rain6657.ktehviewer.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.rain6657.ktehviewer.R
import io.github.rain6657.ktehviewer.models.GallaryInfo
import io.github.rain6657.ktehviewer.utils.network.EhApiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    public val searchTitleText: String? = null
    public val searchEditText: String? = null
    public val selectedMenuItem: String? = null


    fun refresh() {
        viewModelScope.launch {
            val Response = EhApiService.EhApi.retrofitService.getHome()
            val GallaryInfoList = GallaryInfo.GallaryInfoPhaser(Response)
        }
    }
    // Todo: Implement the viewmodel
}
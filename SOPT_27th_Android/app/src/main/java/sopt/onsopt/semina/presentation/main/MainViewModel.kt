package sopt.onsopt.semina.presentation.main

import android.widget.GridLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sopt.onsopt.semina.utils.loggingDebug

class MainViewModel : ViewModel() {
    private val _layoutType = MutableLiveData(LIST_LAYOUT)
    val layoutType: LiveData<String>
        get() = _layoutType

    fun onLayoutTypeClick() {
        if (_layoutType.value == LIST_LAYOUT) {
            _layoutType.value = GRID_LAYOUT
            return
        }
        _layoutType.value = LIST_LAYOUT
    }


    companion object {
        const val LIST_LAYOUT = "LIST"
        const val GRID_LAYOUT = "GRID"
    }
}
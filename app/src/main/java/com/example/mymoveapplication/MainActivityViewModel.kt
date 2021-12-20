package com.example.mymoveapplication


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MainActivityViewModel : ViewModel() {

    private val _livedata: MutableLiveData<List<MoveData>> = MutableLiveData()
    val livedata: LiveData<List<MoveData>>
        get() = _livedata

    private var listHardCode = mutableListOf<MoveData>()

    fun moveList (){
        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))
        listHardCode.add(MoveData(R.drawable.ic_launcher_background, "Hello", "2000"))
        listHardCode.add(MoveData(R.drawable.ic_launcher_foreground, "Hello", "2000"))
        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))
        _livedata.value = listHardCode
    }

}
package com.example.laba32.presentation.fragments.dollars

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laba32.data.model.bezgotivka
import com.example.laba32.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class DollarsViewModel : ViewModel() {

    var repo = Repository()
    val Dollarlisr:  MutableLiveData<Response<bezgotivka>> = MutableLiveData()

    fun getDollar(){
        viewModelScope.launch {
            Dollarlisr.value = repo.getBezgotivka()
        }
    }
}
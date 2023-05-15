package com.example.laba32.presentation.fragments.euro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laba32.data.model.bezgotivka
import com.example.laba32.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class EuroViewModel : ViewModel() {
    var repo = Repository()
    val Eurolist: MutableLiveData<Response<bezgotivka>> = MutableLiveData()

    fun getEuro(){
        viewModelScope.launch {
            Eurolist.value = repo.getBezgotivka()
        }
    }
}
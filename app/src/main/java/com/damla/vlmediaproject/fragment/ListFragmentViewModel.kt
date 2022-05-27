package com.damla.vlmediaproject.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damla.vlmediaproject.api.ApiRepository
import com.damla.vlmediaproject.api.model.Character
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragmentViewModel : ViewModel() {

    var myResponse: MutableLiveData<Character> = MutableLiveData()
    private val repository by lazy {
        ApiRepository()
    }

    fun getCharacter() {
        viewModelScope.launch {
            repository.getCharacter().enqueue(object : Callback<Character> {
                override fun onResponse(call: Call<Character>, response: Response<Character>) {
                    myResponse.value = response.body()
                }

                override fun onFailure(call: Call<Character>, t: Throwable) {
                    println(t)
                    println("hata")

                }

            })
        }
    }


}
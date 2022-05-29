package com.damla.vlmediaproject.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damla.vlmediaproject.api.ApiRepository
import com.damla.vlmediaproject.api.model.Result
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragmentViewModel(private val repository : ApiRepository) : ViewModel() {

    var myResponseSingle: MutableLiveData<Result> = MutableLiveData()
//    private val repository by lazy {
//        ApiRepository()
//    }

    fun getSingleCharacter(characterId: Int) {
        viewModelScope.launch {
            repository.getSingleCharacter(characterId).enqueue(object : Callback<Result> {
                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    if (response.isSuccessful) {
                        myResponseSingle.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Result>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        }
    }
}
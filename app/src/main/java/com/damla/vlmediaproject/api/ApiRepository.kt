package com.damla.vlmediaproject.api

import com.damla.vlmediaproject.api.model.Result
import com.damla.vlmediaproject.api.model.Character
import retrofit2.Call

class ApiRepository {
    private val api by lazy { RetrofitInstance.api }
    fun getCharacter(): Call<Character> {
        return api.getCharacter()
    }

    fun getSingleCharacter(characterId: Int): Call<Result> {
        return api.getSingleCharacter(characterId)
    }
}
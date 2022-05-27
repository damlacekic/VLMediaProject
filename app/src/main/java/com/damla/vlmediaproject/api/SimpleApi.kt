package com.damla.vlmediaproject.api

import com.damla.vlmediaproject.api.model.Character
import com.damla.vlmediaproject.api.model.Result

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET("character/?page=1")
    fun getCharacter(): Call<Character>

    @GET("character/{characterId}")
    fun getSingleCharacter(@Path("characterId") characterId: Int): Call<Result>
}
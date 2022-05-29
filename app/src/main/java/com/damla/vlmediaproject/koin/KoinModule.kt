package com.damla.vlmediaproject.koin

import com.damla.vlmediaproject.adapter.CharacterRwAdapter
import com.damla.vlmediaproject.api.ApiRepository
import com.damla.vlmediaproject.api.Constant
import com.damla.vlmediaproject.api.SimpleApi
import com.damla.vlmediaproject.fragment.DetailFragmentViewModel
import com.damla.vlmediaproject.fragment.ListFragmentViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object KoinModule {

    val appModule = module {
        viewModel { ListFragmentViewModel(get()) }
        viewModel { DetailFragmentViewModel(get()) }
        single {
            Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build())).baseUrl(
                    Constant.BASE_URL
                )
                .build().create(SimpleApi::class.java)

        }
        single {
                ApiRepository(get())
        }
        single {
            CharacterRwAdapter(get())
        }


    }

}
package com.damla.vlmediaproject.koin

import com.damla.vlmediaproject.fragment.DetailFragmentViewModel
import com.damla.vlmediaproject.fragment.ListFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModule {

    val viewModelsModule = module {
        viewModel { ListFragmentViewModel() }
        viewModel { DetailFragmentViewModel() }
    }
}
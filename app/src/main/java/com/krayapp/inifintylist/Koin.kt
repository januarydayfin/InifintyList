package com.krayapp.inifintylist

import com.krayapp.inifintylist.model.RedditPagingSource
import com.krayapp.inifintylist.model.repository.remoteAccess.RedditPostSource
import com.krayapp.inifintylist.model.repository.remoteAccess.RetrofitModule
import com.krayapp.inifintylist.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Koin {
    fun getModules() = module {
        single { RetrofitModule.getApi() }
        single { RedditPagingSource(apiSource = get()) }
        viewModel{MainViewModel(pagingSource = get())}
    }
}
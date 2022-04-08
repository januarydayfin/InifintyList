package com.krayapp.inifintylist

import com.krayapp.inifintylist.model.repository.remoteAccess.RedditPostSource
import com.krayapp.inifintylist.model.repository.remoteAccess.RetrofitModule
import org.koin.dsl.module

object Koin {
    fun getModules() = module {
        single<RedditPostSource> { RetrofitModule.getApi() }
    }
}
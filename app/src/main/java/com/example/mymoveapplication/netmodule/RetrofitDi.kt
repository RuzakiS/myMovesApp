package com.example.mymoveapplication.netmodule

import com.example.mymoveapplication.data.net.RetrofitClient
import org.koin.dsl.module

val retrofitDi = module {

    single {
        RetrofitClient.getClient()
    }
}
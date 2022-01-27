package com.example.bookresponcekotiln

import android.annotation.SuppressLint
import android.app.Application

import androidx.lifecycle.MutableLiveData

class BookRepository(application: Application) {
    private val mProjectItems: List<BookModel>? = null
    private val mutableLiveData: MutableLiveData<List<BookModel>> = MutableLiveData()
    var retrofitClient = RetrofitClient()

    @SuppressLint("CheckResult")
    fun getAllPro(): MutableLiveData<List<BookModel>> {

//        var obserable: Single<List<BookModel>> = retrofitClient.getApi()!!.getPosts()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//        obserable.subscribe({ o -> mutableLiveData.setValue(o) }) { e ->
//        }
        return mutableLiveData
    }


}
package com.example.jetpackandrxjavapractise.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.jetpackandrxjavapractise.bean.NewsData
import com.example.jetpackandrxjavapractise.bean.Story
import com.example.jetpackandrxjavapractise.repository.NetRepository
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MyViewModel: ViewModel() {
    private var num=21;

    private val _liveData= MutableLiveData<List<Story>>()
    val liveData: LiveData<List<Story>>
        get()=_liveData

    init {
        receiveNews()
    }


    private fun receiveNews(){
        NetRepository
            .getNews()
            .subscribe(object : Observer<NewsData<Story>>{
                override fun onSubscribe(d: Disposable) {
                }
                override fun onError(e: Throwable) {
                }
                override fun onComplete() {
                }
                override fun onNext(t: NewsData<Story>) {
                    _liveData.postValue(t.stories)
                }
            })
    }
}
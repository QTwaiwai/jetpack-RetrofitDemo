package com.example.jetpackandrxjavapractise.repository

import com.example.jetpackandrxjavapractise.apiservice.ApiService
import com.example.jetpackandrxjavapractise.bean.NewsData
import com.example.jetpackandrxjavapractise.bean.Story
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetRepository {

    private val retrofit = Retrofit.Builder().baseUrl("https://news-at.zhihu.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()

    private val apiService = retrofit.create(ApiService::class.java)

    fun getNews(): Observable<NewsData<Story>> {
        return apiService.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
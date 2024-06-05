package com.example.jetpackandrxjavapractise.apiservice
import com.example.jetpackandrxjavapractise.bean.NewsData
import com.example.jetpackandrxjavapractise.bean.Story
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

        @GET("api/4/news/latest")
        fun getTopNews(): Observable<NewsData<Story>>

        @GET("api/4/news/latest")
        fun getNews(): Observable<NewsData<Story>>

        @GET("api/4/news/before/{time}")
        fun getBeforeNews(@Path("time") time: String): Observable<NewsData<Story>>
}


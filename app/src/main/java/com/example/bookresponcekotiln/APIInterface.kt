package com.example.bookresponcekotiln

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response

interface APIInterface {
//rx call

//    @GET("books")
//    fun getPosts(): Single<List<BookModel>>


//callBack call

//    @GET("books")
//    fun getPosts(): Call<List<BookModel>>


//Coronten call

    @GET("books")
    suspend fun getEmployees(): Response<List<BookModel>>

}
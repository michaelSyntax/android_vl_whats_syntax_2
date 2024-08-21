package com.syntax_institut.whatssyntax.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.data.model.Message
import com.syntax_institut.whatssyntax.data.model.Profile
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "http://81.169.201.230:8080"

private val logger = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface WhatsSyntaxApiService {
    @GET("/group/{number}/contacts")
    suspend fun getContacts(@Path("number") number: Int, @Query("key") key: String): List<Contact>

    @GET("/group/{number}/profile")
    suspend fun getProfile(@Path("number") number: Int, @Query("key") key: String): Profile

    @POST("/group/{number}/profile")
    suspend fun setProfile(@Path("number") number: Int, @Query("key") key: String, @Body profile: Profile)

    @POST("/group/{number}/chats/{chatId}/new-message")
    suspend fun sendMessage(@Body msg: Message, @Path("number") number: Int, @Path("chatId") chatId: Int, @Query("key") key: String)
}

object WhatsSyntaxApi {
    val retrofitService: WhatsSyntaxApiService by lazy { retrofit.create(WhatsSyntaxApiService::class.java) }
}
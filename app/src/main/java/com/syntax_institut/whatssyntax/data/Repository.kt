package com.syntax_institut.whatssyntax.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.data.remote.WhatsSyntaxApi
import com.syntax_institut.whatssyntax.data.remote.WhatsSyntaxApiService

class Repository(private val api: WhatsSyntaxApi) {

    private val number = 1
    private val key = "test"

    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>>
        get() = _contacts


    suspend fun getContacts() {
        val result = api.retrofitService.getContacts(number, key)
        _contacts.postValue(result)
    }
}
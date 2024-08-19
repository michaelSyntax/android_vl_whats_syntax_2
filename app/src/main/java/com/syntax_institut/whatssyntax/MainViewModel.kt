package com.syntax_institut.whatssyntax

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.syntax_institut.whatssyntax.data.Repository
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.data.remote.WhatsSyntaxApi
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Repository(WhatsSyntaxApi)

    val contacts = repository.contacts

    private val _selectedContact = MutableLiveData<Contact>()
    val selectedContact: LiveData<Contact>
        get() = _selectedContact

    fun getContacts() {
        viewModelScope.launch {
            repository.getContacts()
        }
    }

    fun selectContact(contact: Contact) {
        _selectedContact.value = contact
    }
}
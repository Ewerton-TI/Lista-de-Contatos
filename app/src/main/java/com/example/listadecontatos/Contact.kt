package com.example.listadecontatos

import android.provider.ContactsContract

data class Contact(
    var name: String,
    var phone: String,
    var photo: String
)
package com.example.listadecontatos

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import android.provider.ContactsContract
@Parcelize
data class Contact(
    var name: String,
    var phone: String,
    var photo: String
) : Parcelable

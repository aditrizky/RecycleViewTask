package com.binar.recycleviewsample.data

import android.os.Parcelable
import android.widget.TextView
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val userName: String?= null,
    val phoneNumber: String?=null,
    val address: String?=null,
    val profileURL: String?=null
): Parcelable

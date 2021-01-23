package com.rivaldo.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val photo: Int,
    val name: String,
    val username: String,
    val location: String,
    val company: String,
    val followers: String,
    val following: String,
    val repository: String
) : Parcelable

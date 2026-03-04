package com.example.belajarintent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val nama: String,
    val email: String,
    val umur: Int
) : Parcelable
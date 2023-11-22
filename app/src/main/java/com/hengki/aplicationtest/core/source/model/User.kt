package com.hengki.aplicationtest.core.source.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var id: Int = 0,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var token: String? = null
) : Parcelable
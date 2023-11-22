package com.hengki.aplicationtest.core.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class ProductEntity(
    @PrimaryKey
    var id: Int = 0,
    var name: String? = null,
    var deskripsi: String? = null,
    var image: String? = null
) : Parcelable
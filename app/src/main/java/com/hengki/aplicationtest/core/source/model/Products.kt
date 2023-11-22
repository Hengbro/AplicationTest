package com.hengki.aplicationtest.core.source.model

import com.hengki.aplicationtest.R

data class Products(
    val id: Int? = null,
    val name: String? = null,
    val variant: String? = null,
    val image: String? = null,
    val price: Int? = null,
    val stock: Int? = null,
    val imageDummy: Int = R.drawable.tempat_makan

)

package com.hengki.aplicationtest.core.source.remote.request

/**
 * Created by Tisto on 3/11/2021.
 */

class ProductRequest(
    var name: String? = null,
    var description: String? = null,
    var variants: String? = null,
    var image: String? = null,
    var price: Int? = null,
    var stock: Int? = null
)
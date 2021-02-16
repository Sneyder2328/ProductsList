package com.sneyder.productslist.data.model

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("code") val code: String,
    @SerializedName("message_error") val messageError: String,
    @SerializedName("products") val products: List<Product>?
)
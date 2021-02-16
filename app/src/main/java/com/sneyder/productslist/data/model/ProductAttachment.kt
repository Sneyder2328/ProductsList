package com.sneyder.productslist.data.model

import com.google.gson.annotations.SerializedName

data class ProductAttachment(
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String,
    @SerializedName("thumbnail") val thumbnail: String,
)
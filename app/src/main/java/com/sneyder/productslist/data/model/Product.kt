package com.sneyder.productslist.data.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class Product(
    @SerializedName("product_id") val id: Int,
    @SerializedName("lat") val lat: Long,
    @SerializedName("lon") val lon: Long,
    @SerializedName("createdTime") val createdAt: Date,
    @SerializedName("likes") val likes: Int,
    @SerializedName("attachment") val attachment: ProductAttachment,
)
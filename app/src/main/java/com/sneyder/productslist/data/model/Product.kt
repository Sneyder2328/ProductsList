package com.sneyder.productslist.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Product(
    @SerializedName("product_id") val id: Int,
    @SerializedName("lat") val lat: Long,
    @SerializedName("lon") val lon: Long,
    @SerializedName("createdTime") val createdAt: Date,
    @SerializedName("likes") val likes: Int,
    @SerializedName("price") val price: Double,
    @SerializedName("description") val description: String,
    @SerializedName("attachment") val attachment: ProductAttachment,
): Parcelable
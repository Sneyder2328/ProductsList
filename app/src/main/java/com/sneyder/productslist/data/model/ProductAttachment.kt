package com.sneyder.productslist.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductAttachment(
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String,
    @SerializedName("thumbnail") val thumbnail: String,
): Parcelable
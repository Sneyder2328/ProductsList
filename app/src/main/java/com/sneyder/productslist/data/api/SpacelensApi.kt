package com.sneyder.productslist.data.api

import com.sneyder.productslist.data.model.ProductsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SpacelensApi {

    companion object {
        const val END_POINT = "https://devapis.spacelens.com/test/"
        const val GET_PRODUCTS = "products_list.php?latitude=1&longitude=1"
    }

    @GET(GET_PRODUCTS)
    suspend fun getProducts(
        @Header("Authorization") authorization: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): ProductsResponse
}
package com.sneyder.productslist.data.repository

import com.sneyder.productslist.data.api.SpacelensApi
import com.sneyder.productslist.data.model.ProductsResponse
import com.sneyder.productslist.utils.asBase64
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppProductRepository
@Inject constructor(
    private val spacelensApi: SpacelensApi
) : ProductRepository() {

    override suspend fun fetchProducts(): ProductsResponse {
        return spacelensApi.getProducts(getBasicAuth("test", "Fcb7mPap"), 1.0, 1.0)
    }

    private fun getBasicAuth(user: String, password: String) =
        "Basic " + "$user:$password".asBase64()
}
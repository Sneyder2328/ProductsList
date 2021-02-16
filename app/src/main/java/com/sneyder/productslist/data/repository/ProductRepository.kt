package com.sneyder.productslist.data.repository

import com.sneyder.productslist.data.model.ProductsResponse

abstract class ProductRepository {

    abstract suspend fun fetchProducts(): ProductsResponse

}
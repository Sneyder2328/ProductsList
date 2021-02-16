package com.sneyder.productslist.ui.productList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sneyder.productslist.data.model.ProductsResponse
import com.sneyder.productslist.data.repository.ProductRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class ProductListViewModel
@Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    val products by lazy { MutableLiveData<ProductsResponse>() }

    fun loadProducts() {
        viewModelScope.launch {
            val response = withContext(IO) {
                try {
                    productRepository.fetchProducts()
                } catch (e: Exception){
                    e.printStackTrace()
                    null
                }
            }
            response?.let { products.value = it }
        }
    }


}
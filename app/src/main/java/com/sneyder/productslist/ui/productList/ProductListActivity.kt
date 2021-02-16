package com.sneyder.productslist.ui.productList

import android.os.Bundle
import androidx.activity.viewModels
import com.sneyder.productslist.R
import com.sneyder.productslist.ui.base.BaseActivity
import com.sneyder.productslist.utils.debug

class ProductListActivity : BaseActivity() {

    private val viewModel by viewModels<ProductListViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        observeProducts()
        viewModel.loadProducts()
    }

    private fun observeProducts() {
        viewModel.products.observe(this) { products ->
            debug("products = $products")
        }
    }


}
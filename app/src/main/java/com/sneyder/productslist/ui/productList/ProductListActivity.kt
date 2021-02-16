package com.sneyder.productslist.ui.productList

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.sneyder.productslist.R
import com.sneyder.productslist.data.model.Product
import com.sneyder.productslist.databinding.ActivityProductListBinding
import com.sneyder.productslist.ui.base.BaseActivity
import com.sneyder.productslist.ui.productDetails.ProductDetailsActivity
import com.sneyder.productslist.utils.debug

class ProductListActivity : BaseActivity(), ProductListAdapter.ProductListListener {

    private val productListViewModel by viewModels<ProductListViewModel> { viewModelFactory }
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityProductListBinding>(
            this,
            R.layout.activity_product_list
        )
    }
    private val productsAdapter by lazy {
        ProductListAdapter(this)
    }

    override fun onProductSelected(product: Product) {
        startActivity(ProductDetailsActivity.starterIntent(this, product))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this@ProductListActivity
        binding.viewModel = productListViewModel
        binding.productsRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = productsAdapter
        }
        observeProducts()
        productListViewModel.loadProducts()
    }

    private fun observeProducts() {
        productListViewModel.products.observe(this) { response ->
            debug("products = $response")
            response.products?.let { productsAdapter.products = it }
        }
    }

}
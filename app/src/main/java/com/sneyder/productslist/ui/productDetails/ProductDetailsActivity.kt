package com.sneyder.productslist.ui.productDetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.sneyder.productslist.R
import com.sneyder.productslist.data.model.Product
import com.sneyder.productslist.databinding.ActivityProductDetailBinding
import com.sneyder.productslist.databinding.ActivityProductListBinding
import com.sneyder.productslist.ui.base.BaseActivity

class ProductDetailsActivity : BaseActivity() {

    companion object {

        private const val EXTRA_PRODUCT = "product"

        fun starterIntent(context: Context, product: Product): Intent {
            val starter = Intent(context, ProductDetailsActivity::class.java)
            starter.putExtra(EXTRA_PRODUCT, product)
            return starter
        }

    }

    private val product: Product? by lazy { intent.getParcelableExtra(EXTRA_PRODUCT) }
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityProductDetailBinding>(
            this,
            R.layout.activity_product_detail
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.lifecycleOwner = this@ProductDetailsActivity
        product?.let { binding.product = it }
        binding.executePendingBindings()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
package com.sneyder.productslist.ui.productList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sneyder.productslist.data.model.Product
import com.sneyder.productslist.databinding.ActivityProductListItemBinding
import com.sneyder.productslist.utils.debug

class ProductListAdapter(
    private val productListListener: ProductListListener
) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    var products: List<Product> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ActivityProductListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.count()

    inner class ProductViewHolder(private val binding: ActivityProductListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            debug("bind(product)=$product")
            binding.product = product
            binding.listener = productListListener
            binding.executePendingBindings()
        }
    }

    interface ProductListListener {
        fun onProductSelected(product: Product)
    }

}
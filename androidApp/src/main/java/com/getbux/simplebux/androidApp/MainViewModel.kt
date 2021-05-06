package com.getbux.simplebux.androidApp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.getbux.simplebux.kmm.shared.BuxRepository
import com.getbux.simplebux.kmm.shared.Product
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = BuxRepository()
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val products = repository.fetchProducts()
                _products.value = products
            } catch (e: Exception) {
                Log.d("Nikos", e.toString())
            }

        }
    }
}
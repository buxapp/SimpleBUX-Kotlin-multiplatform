package com.getbux.simplebux.kmm.shared

class BuxRepository {

    private val buxAPI = BuxAPI()

    suspend fun fetchProducts(): List<Product> {
        return listOf(buxAPI.fetchProducts())
    }
}
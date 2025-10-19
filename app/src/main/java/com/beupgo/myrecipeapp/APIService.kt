package com.beupgo.myrecipeapp

interface ApiService {

    suspend fun getCategories():CategoriesResponse
}